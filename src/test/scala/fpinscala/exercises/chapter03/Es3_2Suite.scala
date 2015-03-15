package fpinscala.exercises.chapter03

import org.scalatest.FunSuite
import Es3_2._

class Es3_2Suite extends FunSuite {

  test("it should return the tail for a non empty list") {
    val l = List(1, 2, 3, 4, 5)
    assert(tail(l) == List(2, 3, 4, 5))
  }

  test("it should throws an exception for tail of the empty list") {
    intercept[MatchError] {
      tail(Nil)
    }
  }

  test("it should return the empty list for tail of the empty list") {
    assert(tailOption(Nil) == Nil)
  }
}
