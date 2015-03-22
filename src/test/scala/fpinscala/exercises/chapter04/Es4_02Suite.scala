package fpinscala.exercises.chapter04

import org.scalatest.{Matchers, FunSuite}
import Es4_02._

class Es4_02Suite extends FunSuite with Matchers {
  test("it should find the variance of a sequence") {
    val numbers = Seq(1.0, 5.0, 15.0, 42.0, 52.0, 99.0)
    mean(numbers) should be(Some(36.0))
    variance(numbers) should be(Some(1148.0))
  }
}
