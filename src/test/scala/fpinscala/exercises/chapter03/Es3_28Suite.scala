package fpinscala.exercises.chapter03

import org.scalatest.FunSuite
import Es3_28._

class Es3_28Suite extends FunSuite {
  test("it should map a tree") {
    val f: Int => Int = x => x * 2
    val tree = Branch(Branch(Leaf(1), Leaf(2)), Leaf(3))

    assert(map(Leaf(21))(f) == Leaf(42))
    assert(map(tree)(f) == Branch(Branch(Leaf(2), Leaf(4)), Leaf(6)))
  }
}
