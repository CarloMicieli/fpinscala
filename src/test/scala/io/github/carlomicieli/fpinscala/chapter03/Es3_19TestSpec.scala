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

package io.github.carlomicieli.fpinscala.chapter03

class Es3_19TestSpec extends Chapter3Spec with Es3_19 {
  describe("Es3.19") {
    it("should filter out elements that don't match the predicate") {
      filter(List(1, 2, 3, 4, 5))(_ % 2 == 0) shouldBe List(2, 4)
      filter(emptyList)(_ % 2 == 0) shouldBe emptyList
    }

    it("should return the empty list if no element is matching the predicate") {
      filter(listFrom1to10)(_ > 100) shouldBe emptyList
    }

    it("should remove of the odd numbers from a list") {
      val l = List(1, 2, 3, 4, 5)
      removeOdd(l) shouldBe List(2, 4)
    }
  }
}
