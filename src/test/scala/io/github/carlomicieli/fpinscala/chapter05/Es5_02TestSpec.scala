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

import io.github.carlomicieli.AbstractTestSpec

class Es5_02TestSpec extends AbstractTestSpec with SampleStreams {
  describe("Es5.2") {
    describe("drop") {
      it("drop(0) should return the original stream") {
        numbersStream.drop(0).toList shouldBe numbersStream.toList
      }

      it("drop(3) should reduce the resulting stream length by 3") {
        numbersStream.drop(3).length shouldBe (numbersStream.length - 3)
      }

      it("drop(length) should return the empty stream") {
        numbersStream.drop(numbersStream.length).length shouldBe 0
      }
    }

    describe("take") {
      it("take(length) should return the original stream") {
        numbersStream.take(numbersStream.length).toList shouldBe numbersStream.toList
      }

      it("take(0) should return the empty stream") {
        numbersStream.take(0) shouldBe emptyStream
      }

      it("take(1) should return a Stream with only the original stream head") {
        val stream2 = numbersStream.take(1)
        stream2.length shouldBe 1
        stream2.headOption shouldBe numbersStream.headOption
      }
    }
  }
}
