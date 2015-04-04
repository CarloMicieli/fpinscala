package fpinscala.exercises.chapter06

/**
 * EXERCISE 6.2] Write a function to generate a `Double` between 0 and 1, not including 1. Note: You can
 *               use `Int.MaxValue` to obtain the maximum positive integer value, and you can use
 *               `x.toDouble` to convert an `x: Int` to a `Double`.
 */
object Es6_02 {
  def double(rng: RNG): (Double, RNG) = {
    rng.nextDouble
  }
}
