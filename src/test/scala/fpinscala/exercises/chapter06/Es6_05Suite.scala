package fpinscala.exercises.chapter06

import org.scalatest.FunSuite
import Es6_05._

class Es6_05Suite extends FunSuite {
  test("it should return double values") {
    val (n1, rng) = double(SimpleRNG(42))
    assert(n1 == 0.007524831689672932)

    val (n2, _) = double(rng)
    assert(n2 == 0.5967354856416283)
  }
}
