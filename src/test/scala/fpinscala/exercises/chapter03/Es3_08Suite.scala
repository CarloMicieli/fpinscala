package fpinscala.exercises.chapter03

import org.scalatest.FunSuite

class Es3_08Suite extends FunSuite {
  test("foldRight is constructing a list") {
    assert(Es3_08() == List(1, 2, 3))
  }
}
