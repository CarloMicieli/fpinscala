package fpinscala.exercises.chapter03

import org.scalatest.FunSuite
import Es3_20._

class Es3_20Suite extends FunSuite {
  test("it should apply a function to each list element and then flatten the result") {
    val f = (i: Int) => List(i, i + 10)

    assert(flatMap(List.empty[Int])(f) == Nil)
    assert(flatMap(List(1, 2, 3))(f) == List(1, 11, 2, 12, 3, 13))
    assert(flatMap(List(1, 2, 3))(f) == flatMapV2(List(1, 2, 3))(f))
    assert(flatMap(List(1, 2, 3))(f) == flatMapV3(List(1, 2, 3))(f))
  }
}
