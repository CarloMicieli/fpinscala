package fpinscala.exercises.chapter03

sealed trait List[+A] {
  def isEmpty: Boolean

  def head: A

  def tail: List[A]

  def ::[B >: A](x: B): List[B] = new ::(x, this)

  def ++[B >: A](that: List[B]): List[B] = this match {
    case Nil     => that
    case x :: xs => x :: (xs ++ that)
  }

  def reverse = foldLeft(List.empty[A])((xs, x) => x :: xs)

  def map[B](f: A => B): List[B] =
    foldLeft(List.empty[B])((xs, x) => f(x) :: xs).reverse

  def flatMap[B](f: A => List[B]): List[B] =
    foldLeft(List.empty[B])((xs, x) => xs ++ f(x))

  // Lazy variant for the foldRight function
  // (source: http://voidmainargs.blogspot.de/2011/08/folding-stream-with-scala.html)
  def foldRight[B](continue: (A, => B) => B, z: B)(f: (A, B) => B): B = {
    this match {
      case Nil     => z
      case x :: xs => continue(x, f(x, xs.foldRight(continue, z)(f)))
    }
  }

  def foldRight[B](z: B)(f: (A, B) => B): B = this match {
    case Nil     => z
    case x :: xs => f(x, xs.foldRight(z)(f))
  }

  @annotation.tailrec
  final def foldLeft[B](z: B)(f: (B, A) => B): B = this match {
    case Nil     => z
    case x :: xs => xs.foldLeft(f(z, x))(f)
  }

  def foreach[U](f: (A) => U): Unit = this match {
    case Nil => ()
    case x :: xs =>
      f(x)
      xs.foreach(f)
  }

  def length: Int = this.foldLeft(0)((n, _) => n + 1)
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

  private def mkString(l: List[A]): String = l match {
    case h :: Nil => h.toString
    case h :: t => s"$h, ${mkString(t)}"
  }
}

object :: {
  def unapply[A](xs: List[A]): Option[(A, List[A])] =
    if (xs.isEmpty) scala.None
    else Some((xs.head, xs.tail))
}