package fpinscala.exercises.chapter03

/**
 * EXERCISE 3.12] Write a function that returns the reverse of a list (given List(1,2,3) it returns
 *                List(3,2,1) ). See if you can write it using a fold.
 */
object Es3_12 {
  def reverse[A](as: List[A]): List[A] =
    as.foldLeft(List.empty[A])((xs, x) => x :: xs)
}
