package fpinscala.exercises.chapter03

/**
 * EXERCISE 3.16] Write a function that transforms a list of integers by adding 1 to each element.
 *                (Reminder: this should be a pure function that returns a new `List`!)
 */
object Es3_16 {
  def addOne(as: List[Int]): List[Int] =
    as.foldLeft(List.empty[Int])((acc, x) => (x + 1) :: acc).reverse
}
