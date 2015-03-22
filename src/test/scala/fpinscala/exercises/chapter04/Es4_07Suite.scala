package fpinscala.exercises.chapter04

import org.scalatest.{Matchers, FunSuite}
import Es4_07._

class Es4_07Suite extends FunSuite with Matchers {
  test("it should sequence a list of Either values") {
    val l1: List[Either[String, Int]] = List(Right(1), Right(2), Right(3))
    val l2: List[Either[String, Int]] = List(Right(1), Left("first error"), Right(3), Left("second error"))
    sequence(l1) should be(Right(List(1, 2, 3)))
    sequence(l2) should be(Left("first error"))
  }

  test("it should traverse a list of Either values") {
    val f: Int => Either[String, Int] = x => if (x > 0) Right(x) else Left("Negative")
    traverse(List(1, 2, 3))(f) should be(Right(List(1, 2, 3)))
    traverse(List(1, -2, 3))(f) should be(Left("Negative"))
  }
}
