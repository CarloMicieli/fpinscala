package fpinscala.exercises.chapter05

import org.scalatest.FunSuite
import Es5_08._

class Es5_08Suite extends FunSuite {
  test("it should product an infinite stream of a given value") {
    assert(constant(42).take(10).toList.forall(_ == 42))
  }
}
