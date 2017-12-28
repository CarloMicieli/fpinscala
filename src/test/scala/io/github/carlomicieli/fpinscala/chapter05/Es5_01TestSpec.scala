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

package io.github.carlomicieli.fpinscala.chapter05

class Es5_01TestSpec extends Chapter5Spec with Es5_01 {
  describe("Es5.1") {
    describe("toList") {
      it("should produce the empty list from the empty stream") {
        toList(Stream.empty[Int]) shouldBe List.empty[Int]
      }

      it("should produce a list with the same length as the original stream") {
        toList(Stream(1, 2, 3, 4)) shouldBe List(1, 2, 3, 4)
      }

      it("should be stack-safe") {
        val size = 25000
        toList(Stream.positiveNumbers.take(size)).length shouldBe size
      }
    }
  }
}
