package fpinscala.samples.chapter04

import org.scalatest.FunSuite
import Exceptions._

class ExceptionsSuite extends FunSuite {
  test("failingFun: it should fail when the argument is 0") {
    intercept[Exception] {
      failingFn(0)
    }
  }

  test("failingFun: it should return the sum") {
    assert(failingFn(12) == 59)
  }
}
