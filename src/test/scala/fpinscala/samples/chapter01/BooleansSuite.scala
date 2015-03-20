package fpinscala.samples.chapter01

import org.scalatest.FunSuite
import Booleans._

class BooleansSuite extends FunSuite {
  test("it should implement the AND operator") {
    val bTrue = true
    val bFalse = false
    assert(andAlso(bTrue, bTrue))
    assert(!andAlso(bFalse, bFalse))
    assert(!andAlso(bFalse, bTrue))
  }

  test("AND operator should implement short circuiting") {
    val bFalse = false
    def infinite: Boolean = bFalse || infinite
    assert(!andAlso(bFalse, infinite))
  }

  test("it should implement the OR operator") {
    val bTrue = true
    val bFalse = false
    assert(orElse(bTrue, bTrue))
    assert(orElse(bFalse, bTrue))
  }

  test("OR operator should implement short circuiting") {
    val bFalse = false
    val bTrue = true
    def infinite: Boolean = bFalse || infinite
    assert(orElse(bTrue, infinite))
  }

  test("it should implement the XOR operator") {
    val bFalse = false
    val bTrue = true
    assert(orElse(bTrue, bFalse))
    assert(orElse(bFalse, bTrue))
  }
}
