package fpinscala.exercises.chapter03

import org.scalatest.FunSuite
import Es3_19._

class Es3_19Suite extends FunSuite {
  test("it should filter out elements that don't match the predicate") {
    assert(filter(List(1, 2, 3, 4, 5))(_ % 2 == 0) == List(2, 4))
    assert(filter(List.empty[Int])(_ % 2 == 0) == Nil)
  }
}
