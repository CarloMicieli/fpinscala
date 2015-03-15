package fpinscala.exercises.chapter03

import org.scalatest.FunSuite
import Es3_11._

class Es3_11Suite extends FunSuite {
  test("it should sum the list elements") {
    val l = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    assert(sum(l) == 55)
    assert(sum(List.empty[Double]) == 0.0)
  }

  test("it should make the product of the list elements") {
    val l = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    assert(product(l) == 3628800)
    assert(product(List.empty[Double]) == 1.0)
  }

  test("it should find the list length") {
    val l = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    assert(length(l) == 10)
    assert(length(Nil) == 0)
  }
}
