package fpinscala.samples.chapter08

import org.scalatest.{Matchers, FunSuite}

class SkewHeapTests extends FunSuite with Matchers {
  test("it should check whether heaps are valid") {
    val h1 = Fork(1,  Fork(99, Empty, Empty), Empty)
    val h2 = Fork(99, Fork(1,  Empty, Empty), Empty)

    h1.isValid should be(true)
    h2.isValid should be(false)
  }

  test("it should check whether heaps are balanced") {
    val h1 = Fork(1, Fork(2, Empty, Empty), Empty)
    val h2 = Fork(1, Fork(2, Empty, Empty), Fork(3, Empty, Empty))
    val h3 = Fork(1, Fork(2, Empty, Fork(3, Empty, Empty)), Empty)

    h1.isBalanced should be(true)
    h2.isBalanced should be(true)
    h3.isBalanced should be(false)
  }
}