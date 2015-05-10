package fpinscala.exercises.chapter08

/**
 * EXERCISE 8.1] To get used to thinking about testing in this way, come up with properties
 *               that specify the implementation of a `sum: List[Int] => Int` function.
 */
object Es8_01 {

  def sum(xs: List[Int]): Int = xs.foldLeft(0)(_ + _)

  def replicate(x: Int, s: Int): List[Int] = {
    def loop(n: Int, out: List[Int]): List[Int] = {
      if (n == 0) out
      else loop(n - 1, x :: out)
    }

    loop(s, List())
  }

}
