package fpinscala.exercises.chapter05

import org.scalatest.FunSuite
import Es5_12._

class Es5_12Suite extends FunSuite {
  test("it should implement ones in terms of unfold") {
    assert(ones.take(100).toList.forall(_ == 1))
  }

  test("it should implement constant in terms of unfold") {
    assert(constant("42").take(100).toList.forall(_ == "42"))
  }

  test("it should implement from in terms of unfold") {
    assert(from(1).take(10).toList == (1 to 10).toList)
  }

  test("it should implement fibs in terms of unfold") {
    assert(fibs.take(10).toList == List(0, 1, 1, 2, 3, 5, 8, 13, 21, 34))
  }
}
