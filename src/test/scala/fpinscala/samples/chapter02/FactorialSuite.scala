package fpinscala.samples.chapter02

import org.scalatest.FunSuite
import Factorial._

class FactorialSuite extends FunSuite {

  test("factorial of 5 is 120") {
    val hundredAndTwenty = BigInt(120)
    assert(fact1(5) == hundredAndTwenty)
    assert(fact2(5) == hundredAndTwenty)
    assert(fact3(5) == hundredAndTwenty)
    assert(fact4(5) == hundredAndTwenty)
  }

  test("it should return the first 7 factorials") {
    val list = stream.take(7).toList
    assert(list == List(BigInt(1), BigInt(2), BigInt(6), BigInt(24), BigInt(120), BigInt(720), BigInt(5040)))
  }
}
