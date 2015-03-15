package fpinscala.exercises.chapter03

import org.scalatest.FunSuite
import Es3_23._

class Es3_23Suite extends FunSuite {
  test("it should apply a function to corresponding elements in two lists") {
    assert(zipWith(List(1, 2, 3), List(4, 5, 6))(_ + _) == List(5, 7, 9))
    assert(zipWith(List("1", "2", "3"), List("4", "5", "6"))(_ + _) == List("14", "25", "36"))
  }

  test("it should produce a list with the same number of elements as the shortest list") {
    assert(zipWith(List(1, 2), List(4, 5, 6))(_ + _) == List(5, 7))
    assert(zipWith(List(1, 2, 3), List(4, 5))(_ + _) == List(5, 7))
    assert(zipWith(List(1, 2), Nil)(_ + _) == Nil)
    assert(zipWith(Nil, List(4, 5, 6))(_ + _) == Nil)
  }
}
