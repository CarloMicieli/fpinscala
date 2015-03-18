package fpinscala.exercises.chapter03

import org.scalatest.FunSuite
import Es3_26._

class Es3_26Suite extends FunSuite {
  test("it should find the maximum value from a tree") {
    val t1 = Leaf(42)
    val t2 = Branch(Branch(Leaf(1), Leaf(2)), Leaf(3))
    assert(maximum(t1) == 42)
    assert(maximum(t2) == 3)
  }
}
