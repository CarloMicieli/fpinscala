package fpinscala.samples.chapter04

import fpinscala.exercises.chapter04.{None, Option, Some}

import scala.util.control.NoStackTrace

/**
 * It represent a container object that may or may not complete with a valid result.
 */
sealed trait Try[+A] {
  /**
   * Checks whether it represents a computation that ends with a failure.
   * @return `true` if this is a failure; `false` otherwise.
   */
  def isFailure: Boolean = !isSuccess

  /**
   * Checks whether it represents a computation that ends successfully.
   * @return `true` if this is a success; `false` otherwise.
   */
  def isSuccess: Boolean

  /**
   * Returns the inner cause for failure. `None` for success.
   * @return the inner cause for failure.
   */
  def exception[B >: Throwable]: Option[B]

  /**
   * Returns the result value from the computation if completed successfully, or
   * throws an Exception for the failure case.
   */
  def get: A

  def flatten[B](implicit ev: B => Try[B]): Try[B] = get.asInstanceOf[Try[B]]

  def map[B](f: A => B): Try[B] =
    if (isSuccess)
      Success(f(get))
    else
      this.asInstanceOf[Try[B]]

  def flatMap[B](f: A => Try[B]): Try[B] =
    if (isSuccess)
      f(get)
    else
      this.asInstanceOf[Try[B]]

  def recoverWith[B >: A](f: PartialFunction[Throwable, Try[B]]): Try[B] =
    if (isSuccess)
      this
    else
      f(exception.get)

  def filter(p: A => Boolean): Try[A] =
    if (isSuccess && p(get))
      this
    else
      Failure(new NoSuchElementException with NoStackTrace)

  /**
   * Returns <em>empty</em> if this is a Failure or an <em>Optional</em>
   * containing the value if this is a <em>Success</em>.
   *
   * @return an Optional that contains the computation result if Success, <em>empty</em> otherwise.
   */
  def toOption: Option[A] = if (isSuccess) Some(get) else None

  /**
   * Return the computation result if <em>Success</em>, or the value provided
   * by the given function.
   *
   * @param default the function to supply a computation result for <em>Failure</em>
   * @return the computation result if <em>Supplier</em>, or a default value supplied by a function.
   */
  def getOrElse[B >: A](default: => B): B = if (isSuccess) get else default
}

object Try {
  def apply[A](op: => A): Try[A] = try {
    Success(op)
  } catch {
    case ex: Exception => Failure(ex)
  }
}

case class Success[A](get: A) extends Try[A] {
  def isSuccess = true

  def exception[B >: Throwable]: Option[B] = None
}

case class Failure(ex: Throwable) extends Try[Nothing] {
  def isSuccess = false

  def get = throw ex

  def exception[B >: Throwable]: Option[B] = Some(ex)
}