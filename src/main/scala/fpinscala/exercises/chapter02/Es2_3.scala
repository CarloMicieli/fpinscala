package fpinscala.exercises.chapter02

/**
 * EXERCISE 2.3] Let’s look at another example, currying, 9 which converts a
 *               function f of two arguments into a function of one argument
 *               that partially applies f. Here again there’s only one
 *               implementation that compiles. Write this implementation.
 */
object Es2_3 {

  def curry[A, B, C](f: (A, B) => C): A => (B => C) = a => partial(a, f)

  private def partial[A, B, C](a: A, f: (A, B) => C): B => C =
    b => f(a, b)
}
