package fpinscala.exercises.chapter03

import org.scalatest.FunSuite
import Es3_24._

class Es3_24Suite extends FunSuite {
  test("it should check whether a list is a subsequence") {
    val list = List(1,2,3,4)
    val sub1 = List(1, 4)
    val sub2 = List(3, 4, 5)
    val sub3 = List(3, 4)
    assert(!hasSubsequence(list, sub1))
    assert(!hasSubsequence(list, sub2))
    assert(hasSubsequence(list, sub3))
    assert(hasSubsequence(list, List()))
  }
}
