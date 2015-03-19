package fpinscala.exercises.chapter04

/**
 * EXERCISE 4.7] Implement sequence and traverse for Either. These should return the first error
 *               that’s encountered, if there is one.
 */
object Es4_07 {
  def sequence[E, A](es: List[Either[E, A]]): Either[E, List[A]] = ???
  def traverse[E, A, B](as: List[A])(f: A => Either[E, B]): Either[E, List[B]] = ???
}
