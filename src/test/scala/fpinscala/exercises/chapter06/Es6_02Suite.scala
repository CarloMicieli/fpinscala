package fpinscala.exercises.chapter06

import org.scalatest.FunSuite
import Es6_02._

class Es6_02Suite extends FunSuite {
  test("it should produce double number between 0 and 1") {
    val (d, _) = double(SimpleRNG(42))
    assert(d >= 0 && d < 1)
    assert(d == 0.007524831689672932)
  }
}
