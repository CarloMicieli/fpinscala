package fpinscala.exercises.chapter08

import org.scalatest.{Matchers, FunSuite}
import org.scalatest.prop.PropertyChecks
import Es8_01._

class Es8_01Suite extends FunSuite with PropertyChecks with Matchers {

  test("list sum") {
    forAll { (xs: List[Int]) =>
      sum(xs) should be(xs.sum)
    }
  }

  test("list sum: reverse") {
    forAll { (xs: List[Int]) =>
      sum(xs) should be(sum(xs.reverse))
    }
  }

  test("list sum: concat") {
    forAll { (xs: List[Int], ys: List[Int]) =>
      sum(xs ::: ys) should be(sum(xs) + sum(ys))
    }
  }

  test("list sum: cons") {
    forAll { (xs: List[Int], x: Int) =>
      sum(x :: xs) should be(x + sum(xs))
    }
  }

  ignore("list sum: summing the same element") {
    forAll { (size: Int) =>
      whenever(size >= 0) {
        val xs = replicate(1, size)
        sum(xs) should be(xs.size)
      }
    }
  }
}