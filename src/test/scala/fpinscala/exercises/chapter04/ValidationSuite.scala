package fpinscala.exercises.chapter04

import org.scalatest.{Matchers, FunSuite}

class ValidationSuite extends FunSuite with Matchers {
  test("it should append two validation values") {
    (success(41) +++ success(1)) should be(Success(42))
    (failure("error") +++ success(1)) should be(Failure("error"))
    (success(1) +++ failure("error")) should be(Failure("error"))
    (failure("danger.") +++ failure("danger")) should be(Failure("danger.danger"))
  }

  test("it should check whether a validation is success") {
    success(1).isSuccess should be(true)
    success(1).isFailure should be(false)
    failure("error").isSuccess should be(false)
    failure("error").isFailure should be(true)
  }

  def success(n: Int): Validation[String, Int] = Success(n)
  def failure(s: String): Validation[String, Int] = Failure(s)
}
