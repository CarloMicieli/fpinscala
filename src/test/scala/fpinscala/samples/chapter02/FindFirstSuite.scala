package fpinscala.samples.chapter02

import org.scalatest.FunSuite

class FindFirstSuite extends FunSuite {
  test("it should return None when no value makes the predicate true") {
    val a = Array(2, 4, 6, 8, 10)
    assert(FindFirst(a)(_ % 2 != 0) == None)
  }

  test("it should return the first index that makes the predicate true") {
    val a = Array(2, 4, 6, 8, 10)
    assert(FindFirst(a)(_ >= 8) == Some(3))
  }

  test("it should always return None when the array is empty") {
    val empty = new Array[Int](0)
    assert(FindFirst(empty)(_ > 0) == None)
  }
}
