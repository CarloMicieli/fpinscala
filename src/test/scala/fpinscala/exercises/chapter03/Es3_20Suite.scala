package fpinscala.exercises.chapter03

import org.scalatest.FunSuite
import Es3_20._

class Es3_20Suite extends FunSuite {
  test("it should apply a function to each list element and then flatten the result") {
    assert(flatMap(List.empty[Int])(i => List(i, i + 10)) == Nil)
      assert(flatMap(List(1, 2, 3))(i => List(i, i + 10)) == List(1, 11, 2, 12, 3, 13))
  }
}
