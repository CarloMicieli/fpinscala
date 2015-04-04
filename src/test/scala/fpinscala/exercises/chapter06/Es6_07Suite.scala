package fpinscala.exercises.chapter06

import org.scalatest.FunSuite
import Es6_07._
import RNG._

class Es6_07Suite extends FunSuite {
  test("it should combine a sequence of random generators") {
    val seq: List[Rand[Int]] = List.fill(10)(int)
    val (xs, _) = sequence(seq)(SimpleRNG(42))
    assert(xs == List(16159453, -1281479697, -340305902, -2015756020, 1770001318, -1934589059, 1015914512, -1163632441, -94901159, 1837487774))
  }
}
