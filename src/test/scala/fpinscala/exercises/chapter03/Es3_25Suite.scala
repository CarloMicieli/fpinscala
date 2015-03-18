package fpinscala.exercises.chapter03

import org.scalatest.FunSuite
import Es3_25._

class Es3_25Suite extends FunSuite {
  test("it should count the number of nodes in a tree") {
    assert(size(Leaf(42)) == 1)
    assert(size(Branch(Branch(Leaf(1), Leaf(2)), Leaf(3))) == 3)
  }
}
