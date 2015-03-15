package fpinscala.exercises.chapter03

/**
 * EXERCISE 3.20] Write a function flatMap that works like map except that the function given will return
 *                a list instead of a single result, and that list should be inserted into the final resulting
 *                list.
 */
object Es3_20 {
  def flatMap[A, B](as: List[A])(f: A => List[B]): List[B] =
    as.foldLeft(List.empty[B])((xs, x) => xs ++ f(x))
}
