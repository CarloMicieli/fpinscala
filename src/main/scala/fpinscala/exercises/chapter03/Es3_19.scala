package fpinscala.exercises.chapter03

/**
 * EXERCISE 3.19] Write a function `filter` that removes elements from a list unless they satisfy
 *                a given predicate. Use it to remove all odd numbers from a `List[Int]`.
 */
object Es3_19 {
  def filter[A](as: List[A])(p: A => Boolean): List[A] =
    as.foldLeft(List.empty[A])((xs, x) => if (p(x)) x :: xs else xs).reverse

  def removeOdd(list: List[Int]): List[Int] = {
    val isEven: Int => Boolean = x => x % 2 == 0
    filter(list)(isEven)
  }
}
