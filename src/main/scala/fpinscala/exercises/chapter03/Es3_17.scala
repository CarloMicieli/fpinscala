package fpinscala.exercises.chapter03

/**
 * EXERCISE 3.17] Write a function that turns each value in a `List[Double]` into a `String`. You can use
 *                the expression `d.toString` to convert some `d: Double` to a `String`.
 */
object Es3_17 {
  def convert(as: List[Double]): List[String] =
    as.foldLeft(List.empty[String])((xs, x) => x.toString :: xs).reverse
}
