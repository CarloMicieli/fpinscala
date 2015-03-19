package fpinscala.exercises.chapter05

/**
 * EXERCISE 5.11] Write a more general stream-building function called unfold. It takes an initial state,
 *                and a function for producing both the next state and the next value in the generated
 *                stream.
 */
object Es5_11 {
  def unfold[A, S](z: S)(f: S => Option[(A, S)]): Stream[A] = ???
}
