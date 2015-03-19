package fpinscala.exercises.chapter04

sealed trait Option[+A] {
  /**
   * Apply f if the Option is not None.
   */
  def map[B](f: A => B): Option[B] = ???

  /**
   * Apply f, which may fail, to the Option if not None.
   */
  def flatMap[B](f: A => Option[B]): Option[B] = ???

  def get: A

  def isEmpty: Boolean

  def getOrElse[B >: A](default: => B): B = ???

  /**
   * It returns the first Option if it’s defined; otherwise, it returns the second Option.
   */
  def orElse[B >: A](ob: => Option[B]): Option[B] = ???

  def filter(f: A => Boolean): Option[A] = ???
}

case class Some[+A](get: A) extends Option[A] {
  def isEmpty = false
}

case object None extends Option[Nothing] {
  def isEmpty = true
  def get = throw new NoSuchElementException("empty")
}
