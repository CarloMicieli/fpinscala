package fpinscala.exercises.chapter06

/**
 * EXERCISE 6.6] Write the implementation of `map2` based on the following signature. This function
 *               takes two actions, `ra` and `rb`, and a function `f` for combining their results, and returns
 *               a new action that combines them.
 */
object Es6_06 {
  def map2[A, B, C](ra: Rand[A], rb: Rand[B])(f: (A, B) => C): Rand[C] = ???
}
