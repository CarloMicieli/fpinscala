package fpinscala.exercises.chapter05

import org.scalatest.FunSuite
import Es5_05._

class Es5_05Suite extends FunSuite {
  test("it should take elements while they match predicate") {
    val s = Stream.range(1, 100)
    assert(takeWhile(s)(_ < 10).toList == (1 until 10).toList)
  }

  test("it should work for infinite streams") {
    val s = Stream.from(42)
    assert(takeWhile(s)(_ < 50).toList == (42 until 50).toList)
  }
}
