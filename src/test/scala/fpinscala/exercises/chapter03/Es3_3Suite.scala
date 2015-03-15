package fpinscala.exercises.chapter03

import org.scalatest.FunSuite
import Es3_3._

class Es3_3Suite extends FunSuite {
  test("it should replace the head of a list") {
    val l = List(1, 2, 3, 4, 5)
    assert(setHead(42, l) == List(42, 2, 3, 4, 5))
    assert(setHead(42, Nil) == Nil)
  }
}
