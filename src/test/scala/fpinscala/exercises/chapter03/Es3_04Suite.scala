package fpinscala.exercises.chapter03

import org.scalatest.FunSuite
import Es3_04._

class Es3_04Suite extends FunSuite {
  test("it should drop the first n elements from a list") {
    val l = List(1, 2, 3, 4, 5, 6)
    assert(drop(l, 2) == List(3, 4, 5, 6))
  }

  test("it should return the same list when dropping 0 elements") {
    val l = List(1, 2, 3, 4, 5, 6)
    assert(drop(l, 0) == l)
  }

  test("it should return the empty list when dropping n elements from the empty list") {
    assert(drop(Nil, 4) == Nil)
  }

  test("it should return the empty list when the number of dropped elements is more the list length") {
    val l = List(1, 2, 3, 4, 5, 6)
    assert(drop(l, 99) == Nil)
  }

  test("it should return the original list dropping a negative number of elements") {
    val l = List(1, 2, 3, 4, 5, 6)
    assert(drop(l, -99) == l)
  }
}
