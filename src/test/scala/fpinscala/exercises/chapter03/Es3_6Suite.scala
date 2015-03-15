package fpinscala.exercises.chapter03

import org.scalatest.FunSuite
import Es3_6._

class Es3_6Suite extends FunSuite {
  test("it should return all the elements but the last one") {
    val l = List(1, 2, 3, 4, 5, 6)
    assert(init(l) == List(1, 2, 3, 4, 5))
  }

  test("it should throw an exception when the list is empty") {
    intercept[NoSuchElementException] {
      init(Nil)
    }
  }
}
