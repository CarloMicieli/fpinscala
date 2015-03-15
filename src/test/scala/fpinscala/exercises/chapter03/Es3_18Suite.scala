package fpinscala.exercises.chapter03

import org.scalatest.FunSuite
import Es3_18._

class Es3_18Suite extends FunSuite {
  test("it should apply a function to each element in the list") {
    assert(map(List(1, 2, 3, 4))(_ * 2) == List(2, 4, 6, 8))
    assert(map(Nil : List[Int])(_ * 2) == Nil)
  }
}
