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

class Es5_03TestSpec extends Chapter5Spec with Es5_03 {
  describe("Es5.3") {
    describe("takeWhile") {
      it("should take elements while predicate match") {
        takeWhile(numbersStream)(n => n < 3) shouldBe Stream(1, 2)
      }

      it("should return an empty stream when predicate doesn't match any element") {
        takeWhile(numbersStream)(n => n > 999) shouldBe emptyStream
      }
    }

    describe("dropWhile") {
      it("should drop elements while predicate match") {
        dropWhile(numbersStream)(n => n < 3) shouldBe Stream(3, 4, 5, 6, 7)
      }

      it("should return all the original stream elements when predicate doesn't match any element") {
        dropWhile(numbersStream)(n => n > 999) shouldBe numbersStream
      }
    }
  }
}
