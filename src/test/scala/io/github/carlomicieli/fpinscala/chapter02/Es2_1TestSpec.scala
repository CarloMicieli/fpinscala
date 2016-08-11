/*
 * Copyright 2016 Carlo Micieli
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

package io.github.carlomicieli.fpinscala.chapter02

import io.github.carlomicieli.AbstractTestSpec

class Es2_1TestSpec extends AbstractTestSpec with Es2_1 {

  describe("Es 2.1: fib()") {
    it("should return 0 as the 0 fibonacci number") {
      fib(0) shouldBe 0
    }

    it("should return 1 as the 1st fibonacci number") {
      fib(1) shouldBe 1
    }

    it("should return 13 as the 7th fibonacci number") {
      fib(7) shouldBe 13
    }

    it("should be undefined for negative numbers") {
      val e = intercept[IllegalArgumentException] {
        fib(-1)
      }
    }
  }
}
