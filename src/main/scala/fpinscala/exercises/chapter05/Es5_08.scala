package fpinscala.exercises.chapter05

/**
 * EXERCISE 5.8] Generalize ones slightly to the function constant, which returns an infinite Stream of
 *               a given value.
 */
object Es5_08 {
  def constant[A](a: A): Stream[A] = Stream.cons(a, constant(a))
}
