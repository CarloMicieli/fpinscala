package fpinscala.exercises.chapter03

/**
 * EXERCISE 3.9] Compute the `length` of a list using `foldRight`.
 */
object Es3_09 {
  def length[A](as: List[A]): Int = as.foldRight(0)((_, n) => n + 1)
}
