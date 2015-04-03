package fpinscala.exercises.chapter05

import org.scalatest.FunSuite
import Es5_04._

class Es5_04Suite extends FunSuite {
  test("it should return true when all elements match the predicate") {
    val s = Stream.range(1, 100)
    assert(s.forAll(_ < 1000))
  }

  test("it should return false as soon as it find a non matching element") {
    val s = Stream.range(1, 100)
    assert(!s.forAll(_ > 1000))
  }

  test("it should manage infinite stream if a non matching element exists") {
    val s = Stream.from(42)
    assert(!s.forAll(_ == 0))
  }
}
