package fpinscala.exercises.chapter04

/**
 * EXERCISE 4.2] Implement the `variance` function in terms of `flatMap`. If the mean of a sequence is m,
 *               the variance is the mean of `math.pow(x - m, 2)` for each element x in the sequence.
 *               See the definition of variance on Wikipedia (http://mng.bz/0Qsr).
 */
object Es4_02 {
  def variance(xs: Seq[Double]): Option[Double] = {
    val variance: (Double, Double) => Double = (m, x) => math.pow(x - m, 2)
    mean(xs).flatMap(m => {
      val f = variance(m, _: Double)
      mean(xs.map(f))
    })
  }

  def mean(xs: Seq[Double]): Option[Double] =
    if (xs.isEmpty) None
    else {
      val m = math.round(xs.sum / xs.length)
      Some(m)
    }
}
