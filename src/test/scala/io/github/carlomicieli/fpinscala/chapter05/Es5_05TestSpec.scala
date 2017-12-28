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

class Es5_05TestSpec extends Chapter5Spec with Es5_05 {
  describe("Es5.5") {
    describe("takeWhile") {
      it("should take elements while they match predicate") {
        takeWhile(streamFrom1To100)(_ < 10) shouldBe Stream.fromRange(1 until 10)
      }

      it("should return the empty stream when the head doesn't match the predicate") {
        takeWhile(infiniteStream)(_ < 0) shouldBe emptyStream
      }

      it("should work for infinite streams") {
        takeWhile(infiniteStream)(_ < 10) shouldBe Stream.fromRange(0 until 10)
      }
    }
  }
}
