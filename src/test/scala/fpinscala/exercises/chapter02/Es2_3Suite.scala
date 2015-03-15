package fpinscala.exercises.chapter02

import org.scalatest.FunSuite
import Es2_3._

class Es2_3Suite extends FunSuite {
  test("it should produce curried functions") {
    val sum: (Int, Int) => Int = _ + _
    val f = curry(sum)
    assert(f(21).isInstanceOf[Int => Int])
    assert(f(21)(21) == 42)
  }
}
