package fpinscala.exercises.chapter03

import org.scalatest.FunSuite
import Es3_16._

class Es3_16Suite extends FunSuite {
  test("it should add one to list elements") {
    assert(addOne(List(41, 42, 43)) == List(42, 43, 44))
    assert(addOne(Nil) == Nil)
  }
}
