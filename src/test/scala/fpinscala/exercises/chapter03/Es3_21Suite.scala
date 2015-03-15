package fpinscala.exercises.chapter03

import org.scalatest.FunSuite
import Es3_21._

class Es3_21Suite extends FunSuite {
  test("it should implement filter with flatMap") {
    assert(filter(List(1, 2, 3, 4, 5))(_ % 2 == 0) == List(2, 4))
    assert(filter(List.empty[Int])(_ % 2 == 0) == Nil)
  }
}
