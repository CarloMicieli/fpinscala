package fpinscala.exercises.chapter07

import java.util.concurrent.{Callable, TimeUnit, ExecutorService, Future}

object Par {
  type Par[A] = ExecutorService => Future[A]

  private case class UnitFuture[A](get: A) extends Future[A] {
    def isCancelled: Boolean = false
    def get(timeout: Long, unit: TimeUnit): A = get
    def cancel(mayInterruptIfRunning: Boolean): Boolean = false
    def isDone: Boolean = true
  }

  def unit[A](a: A): Par[A] = (es: ExecutorService) => UnitFuture(a)
  def lazyUnit[A](a: => A): Par[A] = fork(unit(a))
  def run[A](s: ExecutorService)(a: Par[A]): Future[A] = a(s)
  def fork[A](a: => Par[A]): Par[A] =
    (es: ExecutorService) => es.submit(new Callable[A] {
      def call(): A = a(es).get
    })

  def map2[A, B, C](a: Par[A], b: Par[B])(f: (A, B) => C): Par[C] = {
    (es: ExecutorService) => {
      val fa = a(es)
      val fb = b(es)
      UnitFuture(f(fa.get, fb.get))
    }
  }

  def asyncF[A, B](f: A => B): A => Par[B] = a => lazyUnit(f(a))

  def sequence[A](ps: List[Par[A]]): Par[List[A]] =
    ps.foldLeft(unit(List.empty[A]))((as, a) => map2(a, as)(_ :: _))

  def parMap[A,B](ps: List[A])(f: A => B): Par[List[B]] = fork {
    val pars: List[Par[B]] = ps.map(asyncF(f))
    sequence(pars)
  }

  def sum(seq: IndexedSeq[Int]): Par[Int] = {
    if (seq.size <= 1)
      unit(seq.headOption getOrElse 0)
    else {
      val (l, r) = seq.splitAt(seq.length / 2)
      val lSum = sum(l)
      val rSum = sum(r)
      Par.map2(Par.fork(lSum), Par.fork(rSum))(_ + _)
    }
  }
}
