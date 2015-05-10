package fpinscala.exercises.chapter08

import org.scalatest.{Matchers, FunSuite}

object Es8_03Suite extends FunSuite with Matchers {
  test("it should implement &&") {
    val success = new Prop {
      def check = true
    }
    val failure = new Prop {
      def check = false
    }

    val p1 = success && success
    p1.check should be(true)

    val p2 = success && failure
    val p3 = failure && failure
    p2.check should be(false)
    p3.check should be(false)
  }
}
