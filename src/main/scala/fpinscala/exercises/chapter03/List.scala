package fpinscala.exercises.chapter03

sealed trait List[+A] {
  def isEmpty: Boolean

  def head: A

  def tail: List[A]

  def ::[B >: A](x: B): List[B] = new ::(x, this)
}

object List {
  def apply[A](items: A*): List[A] =
    if (items.isEmpty) Nil
    else items.head :: apply(items.tail: _*)

  def areEquals[A](l: List[A], r: List[A]): Boolean = (l, r) match {
    case (x :: xs, y :: ys) => x == y && areEquals(xs, ys)
    case (Nil, Nil)         => true
    case _                  => false
  }

  def empty[A]: List[A] = Nil
}

object Nil extends List[Nothing] {
  def isEmpty = true

  def head = throw new NoSuchElementException("Nil.head: list is empty")

  def tail = throw new NoSuchElementException("Nil.tail: list is empty")

  override def toString = "[]"
}

final class ::[A](val head: A, val tail: List[A]) extends List[A] {
  def isEmpty = false

  override def equals(that: Any): Boolean = that match {
    case xs: List[_] => List.areEquals(this, xs)
    case _           => false
  }

  override def toString = "[" + mkString(this) + "]"

  private def mkString(xs: List[A]): String = {
    def rest(xs: List[A]): String = xs match {
      case y :: ys => s", $y" + rest(ys)
      case Nil => ""
    }
    xs.head + rest(xs.tail)
  }
}

object :: {
  def unapply[A](xs: List[A]): Option[(A, List[A])] =
    if (xs.isEmpty) scala.None
    else Some((xs.head, xs.tail))
}