package fpinscala.exercises.chapter05

sealed trait Stream[+A] {
  def headOption: Option[A] = this match {
    case Empty => None
    case Cons(h, t) => Some(h())
  }

  def toList: List[A] = this match {
    case Empty => List.empty[A]
    case Cons(h, t) => h() :: t().toList
  }

  def take(n: Int): Stream[A] = (this, n) match {
    case (Empty, _) => Empty
    case (_, 0) => Empty
    case (Cons(h, t), i) => Cons(h, () => t().take(n - 1))
  }

  def drop(n: Int): Stream[A] = (this, n) match {
    case (Empty, _) => Empty
    case (st, 0) => st
    case (Cons(h, t), i) => t().drop(n - 1)
  }
}

object Empty extends Stream[Nothing]
case class Cons[+A](h: () => A, t: () => Stream[A]) extends Stream[A]

object Stream {
  def cons[A](hd: => A, tl: => Stream[A]): Stream[A] = {
    lazy val head = hd
    lazy val tail = tl
    Cons(() => head, () => tail)
  }

  def empty[A]: Stream[A] = Empty

  def apply[A](as: A*): Stream[A] =
    if (as.isEmpty)
      empty
    else
      cons(as.head, apply(as.tail: _*))
}
