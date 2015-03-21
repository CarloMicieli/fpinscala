package fpinscala.exercises.chapter03

/**
 * An immutable linked list. The list is either a constructed list or the empty list.
 * @tparam A
 */
sealed trait List[+A] {
  /**
   * Checks whether this list is empty.
   * @return
   */
  def isEmpty: Boolean

  /**
   * Selects the first element of this list.
   * @return
   */
  def head: A

  /**
   * Selects all elements except the first.
   * @return
   */
  def tail: List[A]

  /**
   * Adds an element at the beginning of this list.
   * @param x
   * @tparam B
   * @return
   */
  def ::[B >: A](x: B): List[B] = new ::(x, this)

  /**
   * Returns a new list containing the elements from the left hand operand followed by
   * the elements from the right hand operand.
   * @param that
   * @tparam B
   * @return
   */
  def ++[B >: A](that: List[B]): List[B] = this match {
    case Nil => that
    case x :: xs => x :: (xs ++ that)
  }

  /**
   * Returns new list with elements in reversed order.
   * @return
   */
  def reverse = foldLeft(List.empty[A])((xs, x) => x :: xs)

  /**
   * Builds a new list by applying a function to all elements.
   * @param f
   * @tparam B
   * @return
   */
  def map[B](f: A => B): List[B] =
    foldLeft(List.empty[B])((xs, x) => f(x) :: xs).reverse

  /**
   * Builds a new list by applying a function to all elements and using the
   * elements of the resulting lists.
   * @param f
   * @tparam B
   * @return
   */
  def flatMap[B](f: A => List[B]): List[B] =
    foldRight(List.empty[B])((x, xs) => f(x) ++ xs)

  // Lazy variant for the foldRight function
  // (source: http://voidmainargs.blogspot.de/2011/08/folding-stream-with-scala.html)
  def foldRight[B](continue: (A, => B) => B, z: B)(f: (A, B) => B): B = {
    this match {
      case Nil => z
      case x :: xs => continue(x, f(x, xs.foldRight(continue, z)(f)))
    }
  }

  /**
   * Applies a binary operator to all elements of this list and a start value, going right to left.
   * @param z
   * @param f
   * @tparam B
   * @return
   */
  def foldRight[B](z: B)(f: (A, B) => B): B = this match {
    case Nil => z
    case x :: xs => f(x, xs.foldRight(z)(f))
  }

  /**
   * Applies a binary operator to a start value and all elements of this sequence, going left to right.
   * @param z
   * @param f
   * @tparam B
   * @return
   */
  @annotation.tailrec
  final def foldLeft[B](z: B)(f: (B, A) => B): B = this match {
    case Nil => z
    case x :: xs => xs.foldLeft(f(z, x))(f)
  }

  def foreach[U](f: (A) => U): Unit = this match {
    case Nil => ()
    case x :: xs =>
      f(x)
      xs.foreach(f)
  }

  /**
   * The length of the list.
   * @return
   */
  def length: Int = this.foldLeft(0)((n, _) => n + 1)

  /**
   * Converts this list of lists into a list formed by the elements of these lists.
   * @param ev
   * @tparam B
   * @return
   */
  def flatten[B](implicit ev: A => List[B]): List[B] =
    foldRight(List.empty[B])((xss, xs) => xss ++ xs)
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