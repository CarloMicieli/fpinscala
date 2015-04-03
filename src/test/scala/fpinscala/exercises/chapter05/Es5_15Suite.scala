package fpinscala.exercises.chapter05

import org.scalatest.FunSuite
import Es5_15._

class Es5_15Suite extends FunSuite {
  test("it should produce the tails from a stream") {
    val s = Stream.of(1, 2, 3)
    assert(tails(s).map(_.toList).toList == List(List(1, 2, 3), List(2, 3), List(3), List()))
  }
}
