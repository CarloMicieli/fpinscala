package fpinscala.exercises.chapter03

import org.scalatest.FunSuite
import Es3_09._

class Es3_09Suite extends FunSuite {
  test("it should calculate the length of the empty list") {
    assert(length(Nil) == 0)
  }

  test("it should calculate the length of a list") {
    assert(length(List(1, 2, 3, 4, 5)) == 5)
  }
}
