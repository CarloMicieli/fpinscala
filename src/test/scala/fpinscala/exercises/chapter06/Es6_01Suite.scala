package fpinscala.exercises.chapter06

import org.scalatest.FunSuite
import Es6_01._

class Es6_01Suite extends FunSuite {
  test("it should produce non negative random numbers") {
    val rng = SimpleRNG(42)

    val (n1, rng2) = nonNegativeInt(rng)
    assert(n1 >= 0)

    val (n2, _) = nonNegativeInt(rng)
    assert(n2 >= 0)
  }
}
