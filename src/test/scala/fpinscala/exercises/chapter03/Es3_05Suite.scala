package fpinscala.exercises.chapter03

import org.scalatest.FunSuite
import Es3_05._

class Es3_05Suite extends FunSuite {
  test("it should return the empty list when working on the empty list") {
    assert(dropWhile[Int](Nil)(_ > 0) == Nil)
  }

  test("it should drop elements from a list when the predicate is true") {
    val l = List(1, 2, 3, 4, 5, 6)
    assert(dropWhile(l)(_ < 3) == List(3, 4, 5, 6))
  }

  test("it should return the empty list when all elements match the predicate") {
    val l = List(1, 2, 3, 4, 5, 6)
    assert(dropWhile(l)(_ < 99) == Nil)
  }

  test("it should return the original list when no element matches the predicate") {
    val l = List(1, 2, 3, 4, 5, 6)
    assert(dropWhile(l)(_ > 99) == l)
  }
}
