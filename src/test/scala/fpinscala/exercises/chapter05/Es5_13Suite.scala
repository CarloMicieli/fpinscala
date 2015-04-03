package fpinscala.exercises.chapter05

import org.scalatest.FunSuite
import Es5_13._

class Es5_13Suite extends FunSuite {
  ignore("it should implement map in terms of unfold") {
    val s = Stream.range(1, 5)
    assert(map(s)(_ * 2).toList == List())
  }
}
