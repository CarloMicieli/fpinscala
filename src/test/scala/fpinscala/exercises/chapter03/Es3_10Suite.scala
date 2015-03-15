package fpinscala.exercises.chapter03

import org.scalatest.FunSuite
import Es3_10._

class Es3_10Suite extends FunSuite {
  test("foldRight is not stack-safe: it should blow the stack with long lists") {
    intercept[StackOverflowError] {
      blowTheStack()
    }
  }

  test("foldLeft is tail call optimized: it won't blow the stack") {
    assert(stackSafeCount() == 5000050000L)
  }
}
