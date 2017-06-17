/*
 * Copyright 2017 CarloMicieli
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

class Es4_08TestSpec extends AbstractTestSpec with Es4_08 {
  describe("Es4.8") {
    it("should append validation values") {
      val Success(n) = positive(7) +++ positive(10) +++ positive(25)
      n shouldBe 42
    }

    it("should validate a Person") {
      val Success(values) = mkPerson("John Doe", 42)
      values shouldBe List("John Doe", 42)

      val Failure(errors) = mkPerson("", -10)
      errors shouldBe List("Name is empty.", "Age is out of range.")
    }

    def positive(i: Int): Validation[List[String], Int] = {
      if (i > 0) {
        Success(i)
      } else {
        Failure(List(s"Non positive integer $i"))
      }
    }
  }
}
