package fpinscala.exercises.chapter05

import org.scalatest.FunSuite
import Es5_09._

class Es5_09Suite extends FunSuite {
  test("it should produce an infinite stream of integer starting from n") {
    assert(from(42).take(100).toList == (42 until 142).toList)
  }
}
