package fpinscala.exercises.chapter03

import org.scalatest.FunSuite
import Es3_17._

class Es3_17Suite extends FunSuite {
  test("it should convert each list element to string") {
    assert(convert(List(42.0, 44.0)) == List("42.0", "44.0"))
    assert(convert(Nil) == Nil)
  }
}
