package fpinscala.exercises.chapter02

import org.scalatest.FunSuite
import Es2_1._

class Es2_1Suite extends FunSuite {

  test("The 7th fibonacci number is 21") {
    assert(fib(7) == 21)
    assert(fibIter(7) == 21)
  }

  test("It should be undefined for negative numbers") {
    intercept[IllegalArgumentException] {
      fibIter(-1)
    }
  }
}
