package fpinscala.exercises.chapter05

import org.scalatest.FunSuite
import Es5_02._

class Es5_02Suite extends FunSuite {
  test("it should take n elements from a stream") {
    assert(takeFromStream(Stream(1, 2, 3, 4), 2) == List(1, 2))
    assert(Stream(1, 2, 3).take(0).toList == List())
    assert(Stream(1, 2, 3).take(1).toList == List(1))
    assert(Stream(1, 2, 3).take(6).toList == List(1, 2, 3))
  }

  test("it should drop n elements from a stream") {
    assert(dropFromStream(Stream(1, 2, 3, 4), 2) == List(3, 4))
    assert(Stream(1, 2, 3).drop(0).toList == List(1, 2, 3))
    assert(Stream(1, 2, 3).drop(4).toList == List())
  }
}
