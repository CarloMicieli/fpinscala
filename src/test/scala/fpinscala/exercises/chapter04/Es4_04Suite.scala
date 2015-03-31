package fpinscala.exercises.chapter04

import org.scalatest.{Matchers, FunSuite}
import Es4_04._

class Es4_04Suite extends FunSuite with Matchers {
  test("it should combine a sequence of Some values") {
    val l = List(Some(1), Some(2), Some(3), Some(4))
    sequence(l) should be(Some(List(1, 2, 3, 4)))
    sequenceV2(l) should be(Some(List(1, 2, 3, 4)))
  }

  test("it should combine a sequence of Option values") {
    val l = List(Some(1), Some(2), None, Some(4))
    sequence(l) should be(None)
    sequenceV2(l) should be(None)
  }
}
