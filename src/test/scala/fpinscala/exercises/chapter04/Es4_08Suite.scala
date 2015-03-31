package fpinscala.exercises.chapter04

import org.scalatest.{Matchers, FunSuite}
import Es4_08._

class Es4_08Suite extends FunSuite with Matchers {

  test("it should append validation values") {
    val Success(n) = positive(7) +++ positive(10) +++ positive(25)
    assert(n == 42)
  }

  test("it should validate a Person") {
    val Success(values) = mkPerson("John Doe", 42)
    values should be(List("John Doe", 42))

    val Failure(errors) = mkPerson("", -10)
    errors should be(List("Name is empty.", "Age is out of range."))
  }

  def positive(i: Int): Validation[List[String], Int] = {
    if (i > 0) Success(i)
    else Failure(List(s"Non positive integer $i"))
  }
}
