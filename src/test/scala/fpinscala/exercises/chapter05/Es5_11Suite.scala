package fpinscala.exercises.chapter05

import org.scalatest.FunSuite
import Es5_11._

class Es5_11Suite extends FunSuite {
  test("it should produce a stream unfolding a function") {
    val f: Int => Option[(Int, Int)] = x => if (x < 5) Some((x * 2, x + 1)) else None
    assert(unfold(0)(f).toList == List(0, 2, 4, 6, 8))
  }
}
