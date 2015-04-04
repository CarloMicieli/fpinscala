package fpinscala.exercises.chapter06

import org.scalatest.FunSuite
import Es6_08._

class Es6_08Suite extends FunSuite {
  test("it should produce non negative numbers") {
    val (n, rng) = nonNegativeLessThan(100)(SimpleRNG(42))
    val (n2, _) = nonNegativeLessThan(100)(rng)
    assert(n == 53)
    assert(n2 == 97)
  }
}
