package fpinscala.exercises.chapter06

import org.scalatest.FunSuite
import Es6_04._

class Es6_04Suite extends FunSuite {
  test("it should produce a list of random numbers") {
    val rng = SimpleRNG(42)
    val (num, _) = ints(5)(rng)
    assert(num == List(1770001318, -2015756020, -340305902, -1281479697, 16159453))
  }
}
