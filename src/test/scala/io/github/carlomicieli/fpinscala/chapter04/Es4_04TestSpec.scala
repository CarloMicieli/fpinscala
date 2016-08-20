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

package io.github.carlomicieli.fpinscala.chapter04

import io.github.carlomicieli.AbstractTestSpec
import Option._

class Es4_04TestSpec extends AbstractTestSpec with Es4_04 {
  describe("Es4.4") {
    describe("sequence()") {
      it("should combine a sequence of Some values") {
        val l = List(some(1), some(2), some(3), some(4))
        sequence(l) shouldBe some(List(1, 2, 3, 4))
      }

      it("should combine a sequence of Option values") {
        val l = List(some(1), some(2), none[Int], some(4))
        sequence(l) shouldBe none[Int]
      }
    }
  }

}
