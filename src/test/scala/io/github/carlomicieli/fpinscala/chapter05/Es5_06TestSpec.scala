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

package io.github.carlomicieli.fpinscala.chapter05

class Es5_06TestSpec extends Chapter5Spec with Es5_06 {
  describe("Es5.6") {
    describe("headOption") {
      it("should return None as head for empty streams") {
        headOption(emptyStream) shouldBe None
      }

      it("should return Some value as head for non empty streams") {
        headOption(numbersStream) shouldBe Some(1)
      }

      it("should return the head from infinite streams") {
        headOption(infiniteStream) shouldBe Some(0)
      }
    }
  }
}
