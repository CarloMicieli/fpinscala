package fpinscala.exercises.chapter06

import RNG._

/**
 * EXERCISE 6.5] Use `map` to reimplement `double` in a more elegant way.
 */
object Es6_05 {
  def double(rng: RNG): (Double, RNG) =
    map(_.nextInt)(toDouble)(rng)

  private def toDouble(n: Int): Double = n match {
    case Int.MaxValue | Int.MinValue => 0.0
    case i => math.abs(i) / Int.MaxValue.toDouble
  }
}
