package fpinscala.exercises.chapter05

import org.scalatest.FunSuite
import Es5_01._

class Es5_01Suite extends FunSuite {
  test("it should convert a Stream to lists") {
    assert(streamToList() == List(1, 2, 3))
    assert(Stream.empty[Int].toList == List())
    assert(Stream("a", "b", "c").toList == List("a", "b", "c"))
  }
}
