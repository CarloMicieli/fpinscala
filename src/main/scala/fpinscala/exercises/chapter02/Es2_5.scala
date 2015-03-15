package fpinscala.exercises.chapter02

/**
 * EXERCISE 2.5] Implement the higher-order function that composes two functions.
 */
object Es2_5 {
  def compose[A, B, C](f: B => C, g: A => B): A => C = a => f(g(a))
  def andThen[A, B, C](f: A => B, g: B => C): A => C = compose(g, f)
}
