/*
 * Copyright 2017 Carlo Micieli
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.carlomicieli.fpinscala.chapter04

import io.github.carlomicieli.AbstractTestSpec

class ValidationTestSpec extends AbstractTestSpec {
  describe("Validation") {
    it("should append two validation values") {
      (success(41) +++ success(1)) shouldBe Success(42)
      (failure("error") +++ success(1)) shouldBe Failure("error")
      (success(1) +++ failure("error")) shouldBe Failure("error")
      (failure("danger.") +++ failure("danger")) shouldBe Failure("danger.danger")
    }

    it("check whether a validation is success") {
      success(1).isSuccess shouldBe true
      success(1).isFailure shouldBe false
      failure("error").isSuccess shouldBe false
      failure("error").isFailure shouldBe true
    }
  }

  def success(n: Int): Validation[String, Int] = Success(n)
  def failure(s: String): Validation[String, Int] = Failure(s)
}
