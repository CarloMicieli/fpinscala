package fpinscala.exercises.chapter02

/**
 * EXERCISE 2.4] Implement unCurry, which reverses the transformation of curry.
 *               Note that since => associates to the right, A => (B => C) can
 *               be written as A => B => C
 */
object Es2_4 {
  def uncurry[A, B, C](f: A => (B => C)): (A, B) => C = (a, b) => f(a)(b)
}
