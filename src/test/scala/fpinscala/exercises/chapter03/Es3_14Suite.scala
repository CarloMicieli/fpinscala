package fpinscala.exercises.chapter03

import org.scalatest.FunSuite
import Es3_14._

class Es3_14Suite extends FunSuite {
  test("it should append two lists") {
    val a = List(1, 2, 3)
    val b = List(4, 5, 6)
    assert(append(a, b) == List(1, 2, 3, 4, 5, 6))
    assert(append(Nil, b) == b)
    assert(append(a, Nil) == a)
    assert(append(Nil, Nil) == Nil)
  }

  test("it should append two lists (left variant)") {
    val a = List(1, 2, 3)
    val b = List(4, 5, 6)
    assert(appendL(a, b) == appendR(a, b))
  }
}
