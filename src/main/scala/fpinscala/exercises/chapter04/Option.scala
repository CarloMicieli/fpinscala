package fpinscala.exercises.chapter04

sealed trait Option[+A] {
  /**
   * Apply f if the Option is not None.
   */
  def map[B](f: A => B): Option[B] = if (isEmpty) None else Some(f(get))

  /**
   * Apply f, which may fail, to the Option if not None.
   */
  def flatMap[B](f: A => Option[B]): Option[B] = if (isEmpty) None else f(get)

  def get: A

  def isEmpty: Boolean

  def getOrElse[B >: A](default: => B): B = if (isEmpty) default else get

  /**
   * It returns the first Option if it’s defined; otherwise, it returns the second Option.
   */
  def orElse[B >: A](ob: => Option[B]): Option[B] = if (isEmpty) ob else this

  def filter(p: A => Boolean): Option[A] = if (!isEmpty && p(get)) this else None
}

object Option {
  def apply[A](value: A): Option[A] = if (value == null) None else Some(value)
}

case class Some[+A](get: A) extends Option[A] {
  def isEmpty = false
}

case object None extends Option[Nothing] {
  def isEmpty = true

  def get = throw new NoSuchElementException("Option.none: empty")
}
