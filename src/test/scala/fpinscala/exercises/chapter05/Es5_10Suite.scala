package fpinscala.exercises.chapter05

import org.scalatest.FunSuite
import Es5_10._

class Es5_10Suite extends FunSuite {
  test("it should produce a stream with the fibonacci numbers") {
    assert(fibs.take(10).toList == List(0, 1, 1, 2, 3, 5, 8, 13, 21, 34))
  }
}
