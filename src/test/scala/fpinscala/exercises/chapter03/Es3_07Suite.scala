package fpinscala.exercises.chapter03

import org.scalatest.FunSuite
import Es3_07._

class Es3_07Suite extends FunSuite {
  test("it should calculate the product") {
    val l1 = List(1, 2, 3, 4, 5, 6, 7)
    val l2 = List(1, 2, 3, 4, 5, 0, 7)
    assert(product(l1) == 5040)
    assert(product(l2) == 0)
  }

  test("it should calculate the product, lazily") {
    val l1 = List(1, 2, 3, 4, 5, 6, 7)
    val l2 = List(1, 2, 3, 4, 5, 0, 7)
    val l3 = List(1.0, 2.0, 3.0, 4.0, 5.0, 0.0, 7.0)
    assert(lazyProduct(l1) == 5040)
    assert(lazyProduct(l2) == 0)
    assert(lazyProduct(l3) == 0.0)
  }
}
