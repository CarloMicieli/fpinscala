package fpinscala.exercises.chapter03

import org.scalatest.FunSuite
import Es3_22._

class Es3_22Suite extends FunSuite {
  test("it should sum the corresponding elements in two lists") {
    assert(add(List(1, 2, 3), List(4, 5, 6)) == List(5, 7, 9))
  }
}
