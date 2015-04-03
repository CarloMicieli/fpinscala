package fpinscala.exercises.chapter05

import org.scalatest.FunSuite
import Es5_06._

class Es5_06Suite extends FunSuite {
  test("it should return None as head for empty streams") {
    assert(headOption(Stream.empty[Int]) == None)
  }

  test("it should return Some value as head for non empty streams") {
    assert(headOption(Stream.of(1, 2, 3)) == Some(1))
    assert(headOption(Stream.from(42)) == Some(42))
  }
}
