package fpinscala.exercises.chapter05

import org.scalatest.FunSuite

class Es5_03Suite extends FunSuite {
  test("it should take elements while predicate match") {
    val s1 = Stream(1, 2, 3, 4, 5).takeWhile(_ % 2 == 0)
    assert(s1.toList == List(2, 4))
  }

  test("it should return an empty stream when predicate doesn't match any element") {
    val s1 = Stream(1, 2, 3, 4, 5).takeWhile(_ >= 10)
    assert(s1.toList == List())
  }
  
}
