package fpinscala.exercises.chapter06

/**
 * EXERCISE 6.3] Write functions to generate an `(Int, Double)` pair, a `(Double, Int)` pair, and a
 *               `(Double, Double, Double)` 3-tuple. You should be able to reuse the functions you’ve
 *               already written.
 */
object Es6_03 {
  def intDouble(rng: RNG): ((Int, Double), RNG) = {
    val (i, rng2) = rng.nextInt
    val (d, rng3) = rng2.nextDouble
    ((i, d), rng3)
  }

  def doubleInt(rng: RNG): ((Double, Int), RNG) = {
    val (d, rng2) = rng.nextDouble
    val (i, rng3) = rng2.nextInt
    ((d, i), rng3)
  }

  def double3(rng: RNG): ((Double, Double, Double), RNG) = {
    val (d1, rng2) = rng.nextDouble
    val (d2, rng3) = rng2.nextDouble
    val (d3, rng4) = rng3.nextDouble
    ((d1, d2, d3), rng4)
  }
}
