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

package io.github.carlomicieli.fpinscala.chapter05

class Es5_12TestSpec extends Chapter5Spec with Es5_12 {
  describe("Es5.12") {
    describe("ones") {
      it("should implement ones in terms of unfold") {
        ones.take(10) shouldBe Stream.fromValues(1, 1, 1, 1, 1, 1, 1, 1, 1, 1)
      }
    }

    describe("constant") {
      it("should implement constant in terms of unfold") {
        val expected = Stream.fromValues("42", "42", "42", "42", "42", "42", "42", "42", "42", "42")
        constant("42").take(10) shouldBe expected
      }
    }

    describe("from") {
      it("should implement from in terms of unfold") {
        from(1).take(10) shouldBe Stream.fromRange(1 to 10)
      }
    }

    describe("fibs") {
      it("should implement fibs in terms of unfold") {
        fibs.take(10) shouldBe Stream.fromValues(0, 1, 1, 2, 3, 5, 8, 13, 21, 34)
      }
    }
  }
}
