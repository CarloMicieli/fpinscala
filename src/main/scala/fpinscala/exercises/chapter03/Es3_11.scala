package fpinscala.exercises.chapter03

/**
 * EXERCISE 3.11] Write `sum`, `product`, and a function to compute the length of a
 *                list using `foldLeft`.
 */
object Es3_11 {
  def sum[A](as: List[A])(implicit num: Numeric[A]): A = {
    as.foldLeft(num.zero)(sum(_, _))
  }

  def product[A](as: List[A])(implicit num: Numeric[A]): A = {
    as.foldLeft(num.one)(times(_, _))
  }

  def length[A](as: List[A]): Int = as.foldLeft(0)((n, _) => n + 1)

  private def times[A: Numeric](a: A, b: A): A = {
    val numeric = implicitly[Numeric[A]]
    numeric.times(a, b)
  }

  private def sum[A: Numeric](a: A, b: A): A = {
    val numeric = implicitly[Numeric[A]]
    numeric.plus(a, b)
  }
}
