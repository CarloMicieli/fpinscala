package fpinscala.exercises.chapter06

import org.scalatest.FunSuite
import Es6_06._

class Es6_06Suite extends FunSuite {
  test("it should combine two random generators") {
    val ((i, d), _) = map2(_.nextInt, _.nextDouble)((a, b) => (a, b))(SimpleRNG(42))
    assert(i == 16159453)
    assert(d == 0.5967354856416283)
  }
}
