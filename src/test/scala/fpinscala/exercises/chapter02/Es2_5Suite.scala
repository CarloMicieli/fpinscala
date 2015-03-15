package fpinscala.exercises.chapter02

import org.scalatest.FunSuite
import Es2_5._

class Es2_5Suite extends FunSuite {
  test("it should compose functions") {
    val doubleMe = (x: Int) => x * 2
    val toString = (x: Int) => s"Number($x)"

    val f = compose(toString, doubleMe)
    val g = andThen(doubleMe, toString)
    assert(f(21) == "Number(42)")
    assert(g(21) == "Number(42)")
  }
}
