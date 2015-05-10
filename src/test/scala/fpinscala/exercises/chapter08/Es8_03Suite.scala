package fpinscala.exercises.chapter08

import org.scalatest.{Matchers, FunSuite}

object Es8_03Suite extends FunSuite with Matchers {
  test("it should implement &&") {
    val success = new Prop {
      def check = Right(50)
    }
    val failure = new Prop {
      def check = Left(("error", 42))
    }

    val p1 = success && success
    p1.check should be(Right(100))

    val p2 = success && failure
    val p3 = failure && failure
    p2.check should be(Left(("error", 42)))
    p3.check should be(Left(("error", 42)))
  }
}
