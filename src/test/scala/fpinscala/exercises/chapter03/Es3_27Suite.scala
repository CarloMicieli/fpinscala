package fpinscala.exercises.chapter03

import org.scalatest.FunSuite
import Es3_27._

class Es3_27Suite extends FunSuite {
  test("it should find the max depth in a tree") {
    val t1 = Leaf(42)
    val t2 = Branch(Branch(Leaf(1), Leaf(2)), Leaf(3))
    assert(depth(t1) == 0)
    assert(depth(t2) == 2)
  }
}
