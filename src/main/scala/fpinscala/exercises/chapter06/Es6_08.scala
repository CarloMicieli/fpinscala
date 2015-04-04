package fpinscala.exercises.chapter06

import RNG._

/**
 * EXERCISE 6.8] Implement `flatMap`, and then use it to implement `nonNegativeLessThan`.
 */
object Es6_08 {
  def nonNegativeLessThan(n: Int): Rand[Int] = flatMap(nonNegativeInt) {
    i => {
      val mod = i % n
      if (i + (n - 1) - mod >= 0)
        unit(mod)
      else
        nonNegativeLessThan(n)
    }
  }

  private def nonNegativeInt(rng: RNG): (Int, RNG) = {
    val (n1, rng2) = rng.nextInt
    (abs2(n1), rng2)
  }

  private def abs2(n: Int): Int = n match {
    case Int.MinValue => 0
    case _ if n >= 0 => n
    case _ if n < 0 => math.abs(n)
  }
}
