package fpinscala.exercises.chapter06

import org.scalatest.FunSuite
import Es6_03._

class Es6_03Suite extends FunSuite {
  test("it should produce an integer and a double pair") {
    val rng = SimpleRNG(42)
    val ((i, d), _) = intDouble(rng)
    assert(i == 16159453)
    assert(d == 0.5967354856416283)
  }

  test("it should produce a double and an integer pair") {
    val rng = SimpleRNG(42)
    val ((d, i), _) = doubleInt(rng)
    assert(i == -1281479697)
    assert(d == 0.007524831689672932)
  }

  test("it should produce three double numbers") {
    val rng = SimpleRNG(42)
    val ((d1, d2, d3), _) = double3(rng)
    assert(d1 == 0.007524831689672932)
    assert(d2 == 0.5967354856416283)
    assert(d3 == 0.15846728447753344)
  }
}
