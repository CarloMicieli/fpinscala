package fpinscala.exercises.chapter02

import org.scalatest.FunSuite
import Es2_4._

class Es2_4Suite extends FunSuite {
  test("it should produce uncurried functions") {
    val sum: Int => Int => Int = a => b => a + b
    val f = uncurry(sum)
    assert(f(21, 21) == 42)
  }
}
