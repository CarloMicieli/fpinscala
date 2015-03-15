package fpinscala.exercises.chapter03

import org.scalatest.FunSuite
import Es3_12._

class Es3_12Suite extends FunSuite {
  test("it should reverse a list") {
    val l = List(1, 2, 3, 4)
    assert(reverse(l) == List(4, 3, 2, 1))
    assert(reverse(Nil) == Nil)
  }
}
