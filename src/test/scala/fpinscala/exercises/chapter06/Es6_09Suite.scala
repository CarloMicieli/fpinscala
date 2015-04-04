package fpinscala.exercises.chapter06

import org.scalatest.FunSuite
import Es6_09._
import RNG.int

class Es6_09Suite extends FunSuite {
  test("it should implement map in terms of flatMap") {
    val rng = SimpleRNG(42)
    val (n, _) = int(rng)
    val (n2, _) = map(int)(_ * 2)(rng)

    assert(n2 == n * 2)
  }

  test("it should implement map2 in terms of flatMap") {
    val rng = SimpleRNG(42)
    val (n1, rng2) = int(rng)
    val (n2, _) = int(rng2)

    val (n3, _) = map2(int, int)(_ - _)(rng)
    assert(n1 - n2 == n3)
  }
}
