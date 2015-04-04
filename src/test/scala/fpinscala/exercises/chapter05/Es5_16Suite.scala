package fpinscala.exercises.chapter05

import org.scalatest.FunSuite
import Es5_16._

class Es5_16Suite extends FunSuite {
  test("it should fold a stream keeping intermediate results") {
    val s = scanRight(Stream.of(1, 2, 3))(0)(_ + _)
    assert(s.toList == List(6, 5, 3, 0))
  }
}
