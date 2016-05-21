// Copyright (C) 2016 the original author or authors.
// See the LICENCE.txt file distributed with this work for additional
// information regarding copyright ownership.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package fpinscala.exercises.chapter04

import org.scalatest.{ Matchers, FunSuite }

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
