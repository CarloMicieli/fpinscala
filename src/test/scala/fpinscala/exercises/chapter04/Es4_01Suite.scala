package fpinscala.exercises.chapter04

import org.scalatest.FunSuite
import Es4_01._

class Es4_01Suite extends FunSuite {
  test("it should use Option values") {
    assert(answer(2) == Some("life universe and everything"))
    assert(answer(0) == None)
  }
}
