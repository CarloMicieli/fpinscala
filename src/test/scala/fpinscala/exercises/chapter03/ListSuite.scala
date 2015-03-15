package fpinscala.exercises.chapter03

import org.scalatest.FunSuite

class ListSuite extends FunSuite {
  test("it should check whether a list is empty") {
    assert(Nil.isEmpty)
    assert(!List(1, 2).isEmpty)
  }

  test("it should produce string representation for lists") {
    assert(Nil.toString == "[]")
    assert(List(1, 2, 3).toString == "[1, 2, 3]")
  }

  test("it should construct lists with cons") {
    val l = 1 :: 2 :: 3 :: 4 :: Nil
    assert(l == List(1, 2, 3, 4))
  }
}
