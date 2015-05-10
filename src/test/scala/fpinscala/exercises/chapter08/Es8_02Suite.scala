package fpinscala.exercises.chapter08

import org.scalatest.{Matchers, FunSuite}
import org.scalatest.prop.PropertyChecks
import Es8_02._

class Es8_02Suite extends FunSuite with PropertyChecks with Matchers {

  test("list max: contained in list") {
    forAll { (xs: List[Int]) =>
      whenever(xs.nonEmpty) {
        val max = maximum(xs)
        xs.contains(max) should be(true)
      }
    }
  }

  test("list max: no element is bigger") {
    forAll { (xs: List[Int]) =>
      whenever(xs.nonEmpty) {
        val max = maximum(xs)
        xs.exists(_ > max) should be(false)
      }
    }
  }

  test("list max: is the biggest element") {
    forAll { (xs: List[Int]) =>
      whenever(xs.nonEmpty) {
        val max = maximum(xs)
        xs.forall(_ <= max) should be(true)
      }
    }
  }

  test("list max: cons") {
    forAll { (xs: List[Int], x: Int) =>
      whenever(xs.nonEmpty) {
        maximum(x :: xs) should be(math.max(x, maximum(xs)))
      }
    }
  }
}
