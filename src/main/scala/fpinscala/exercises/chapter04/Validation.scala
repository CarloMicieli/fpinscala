package fpinscala.exercises.chapter04

sealed trait Validation[+E, +A] {
  def +++[EE >: E, AA >: A](x: => Validation[EE, AA])
                           (implicit ap1: Appendable[AA],
                                     ap2: Appendable[EE]): Validation[EE, AA] = (this, x) match {
    case (Failure(y), Failure(z)) => Failure(ap2.append(y, z))
    case (f1@Failure(y), _) => f1
    case (_, f2@Failure(z)) => f2
    case (Success(y), Success(z)) => Success(ap1.append(y, z))
  }

  def isSuccess: Boolean
  def isFailure: Boolean = !isSuccess
}

case class Success[A](value: A) extends Validation[Nothing, A] {
  def isSuccess = true
}

case class Failure[E](value: E) extends Validation[E, Nothing] {
  def isSuccess = false
}

trait Appendable[A] {
  def append(a: A, b: A): A
}