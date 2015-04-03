package fpinscala.exercises.chapter05

sealed trait Stream[+A] {
  def isEmpty: Boolean

  def length: Int = this match {
    case Empty => 0
    case Cons(_, t) => 1 + t().length
  }

  def headOption: Option[A] = this match {
    case Empty => None
    case Cons(h, t) => Some(h())
  }

  def toList: List[A] = this match {
    case Empty => List.empty[A]
    case Cons(h, t) =>
      lazy val head = h()
      lazy val tail = t()
      head :: tail.toList
  }

  def take(n: Int): Stream[A] = (this, n) match {
    case (Empty, _) => Empty
    case (_, 0) => Empty
    case (Cons(h, t), i) => Cons(h, () => t().take(n - 1))
  }

  def takeWhile(p: A => Boolean): Stream[A] = this match {
    case Empty => Empty
    case (Cons(h, t)) =>
      lazy val head = h()
      if (p(head))
        Cons(() => head, () => t().takeWhile(p))
      else
        Empty
  }

  def drop(n: Int): Stream[A] = (this, n) match {
    case (Empty, _) => Empty
    case (st, 0) => st
    case (Cons(h, t), i) => t().drop(n - 1)
  }

  def find(p: A => Boolean): Option[A] =
    filter(p).headOption

  def filter(p: A => Boolean): Stream[A] = {
    this match {
      case Empty => Empty
      case Cons(h, t) =>
        lazy val head = h()
        if (p(head)) Stream.cons[A](head, t().filter(p)) else t().filter(p)
    }
  }

  def foldRight[B](z: => B)(f: (A, => B) => B): B = {
    this match {
      case Cons(h, t) => f(h(), t().foldRight(z)(f))
      case Empty => z
    }
  }

  def exists(p: A => Boolean): Boolean =
    foldRight(false)((a, b) => p(a) || b)

  def forAll(p: A => Boolean): Boolean =
    foldRight(true)((a, b) => p(a) && b)

  def append[B >: A](that: => Stream[B]): Stream[B] =
    foldRight(that)((a, b) => Stream.cons(a, b))
}

object Empty extends Stream[Nothing] {
  val isEmpty = true
}
case class Cons[+A](h: () => A, t: () => Stream[A]) extends Stream[A] {
  var isEmpty = false
}

object Stream {
  def of[A](values: A*): Stream[A] =
    if (values.isEmpty) Stream.empty[A]
    else cons(values.head, Stream.of(values.tail: _*))

  def cons[A](hd: => A, tl: => Stream[A]): Stream[A] = {
    lazy val head = hd
    lazy val tail = tl
    Cons(() => head, () => tail)
  }

  def range(lo: Int, hi: Int): Stream[Int] =
    if (lo >= hi) empty[Int]
    else cons(lo, range(lo + 1, hi))

  def empty[A]: Stream[A] = Empty

  def from(n: Int): Stream[Int] = cons(n, from(n + 1))

  def apply[A](as: A*): Stream[A] =
    if (as.isEmpty)
      empty
    else
      cons(as.head, apply(as.tail: _*))
}
