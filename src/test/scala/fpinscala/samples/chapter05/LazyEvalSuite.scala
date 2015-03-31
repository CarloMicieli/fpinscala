package fpinscala.samples.chapter05

import org.scalatest.FunSuite
import LazyEval._

class LazyEvalSuite extends FunSuite {
  test("it should evaluate everything strictly") {
    var i = 0

    val res = cond1(false, {i = i + 1; "A"}, {i = i + 10; "B"})
    assert(res == "B")
    assert(i == 11)
  }

  test("it should evaluate arguments like functions") {
    var i = 0

    val res = cond2(false, () => {i = i + 1; "A"}, () => {i = i + 10; "B"})
    assert(res == "B")
    assert(i == 10)
  }

  test("it should evaluate arguments by name") {
    var i = 0

    val res = cond3(false, {i = i + 1; "A"}, {i = i + 10; "B"})
    assert(res == "B")
    assert(i == 10)
  }

  test("it should evaluate argument twice") {
    var n = 0
    val x = maybeTwice(true, { n = n + 1; 10 })

    assert(x == 20)
    assert(n == 2)
  }

  test("it should evaluate the arguments and memoize their values") {
    var n = 0
    val x = maybeTwice2(true, { n = n + 1; 10 })

    assert(x == 20)
    assert(n == 1)
  }
}
