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

class Es5_04TestSpec extends Chapter5Spec with Es5_04 {
  describe("Es5.4") {
    describe("forAll") {
      it("should return true when all elements match the predicate") {
        forAll(streamFrom1To100)(_ < 1000) shouldBe true
      }

      it("should return false as soon as it find a non matching element") {
        forAll(streamWithUndefinedElement)(_ < 2) shouldBe false
      }

      ignore("should manage infinite stream if a non matching element exists") {
        //TODO: stackoverflow!!!
        forAll(infiniteStream)(_ < 1000) shouldBe false
      }
    }
  }
}
