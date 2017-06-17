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

package io.github.carlomicieli.fpinscala.chapter03

class Es3_05TestSpec extends Chapter3Spec with Es3_05 {
  describe("dropWhile()") {
    it("should return the empty list when working on the empty list") {
      dropWhile[Int](Nil)(_ > 0) shouldBe Nil
    }

    it("should drop elements from a list when the predicate is true") {
      dropWhile(listFrom1to10)(_ < 5) shouldBe List(5, 6, 7, 8, 9, 10)
    }

    it("should return the empty list when all elements match the predicate") {
      dropWhile(listFrom1to10)(_ < 100) shouldBe List.empty[Int]
    }

    it("should return the original list when no element matches the predicate") {
      dropWhile(listFrom1to10)(_ > 100) shouldBe listFrom1to10
    }
  }
}
