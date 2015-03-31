package fpinscala.exercises.chapter04

/**
 * Represents a value of one of two possible types (a disjoint union).
 * Instances of `Either` are either an instance of `Left` or `Right`.
 *
 * @tparam E
 * @tparam A
 */
sealed trait Either[+E, +A] {
  def map[B](f: A => B): Either[E, B] = this match {
    case Left(_) => this.asInstanceOf[Either[E, B]]
    case Right(x) => Right(f(x))
  }

  def flatMap[EE >: E, B](f: A => Either[EE, B]): Either[EE, B] = this match {
    case Right(x) => f(x)
    case Left(_) => this.asInstanceOf[Either[EE, B]]
  }

  def orElse[EE >: E, B >: A](b: => Either[EE, B]): Either[EE, B] = this match {
    case Right(_) => this
    case Left(_) => b
  }

  def map2[EE >: E, B, C](b: Either[EE, B])(f: (A, B) => C): Either[EE, C] =
    this.flatMap(x =>
      b.flatMap(y => Right(f(x, y))))
}

case class Left[+E](value: E) extends Either[E, Nothing]

case class Right[+A](value: A) extends Either[Nothing, A]
