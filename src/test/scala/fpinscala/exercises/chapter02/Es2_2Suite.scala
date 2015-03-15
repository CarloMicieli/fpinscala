package fpinscala.exercises.chapter02

import org.scalatest.FunSuite
import Es2_2._

class Es2_2Suite extends FunSuite {
  test("the empty array is always sorted") {
    val empty: Array[Int] = new Array(0)
    assert(isSorted(empty, ord))
  }

  test("an array with a single element is sorted") {
    assert(isSorted(Array(1), ord))
  }

  test("it should check whether an array is sorted") {
    assert(isSorted(Array(1, 6, 13, 55, 67, 221), ord))
    assert(!isSorted(Array(1, 6, 131, 55, 67, 221), ord))
  }

  test("it should check whether a list is sorted") {
    val sorted = List(1, 23, 67, 890, 1294, 1348, 1500)
    val unsorted = List(14, 42, 223, 32, 12, 455)
    assert(isSorted(sorted))
    assert(!isSorted(unsorted))
  }

  val ord: (Int, Int) => Boolean = (x, y) => x <= y
}
