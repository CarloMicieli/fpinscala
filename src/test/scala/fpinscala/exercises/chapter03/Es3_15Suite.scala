package fpinscala.exercises.chapter03

import org.scalatest.FunSuite
import Es3_15._

class Es3_15Suite extends FunSuite {
  test("it should concat a list of lists") {
    val list = List(List(1, 2), List(4), List(6, 10, 42))
    assert(concat(list) == List(1, 2, 4, 6, 10, 42))
  }
}
