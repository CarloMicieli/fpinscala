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

class Es5_10TestSpec extends Chapter5Spec with Es5_10 {
  describe("Es5.10") {
    describe("fibs") {
      it("should produce a stream with the fibonacci numbers") {
        fibs.take(10) shouldBe Stream.fromValues(0, 1, 1, 2, 3, 5, 8, 13, 21, 34)
      }
    }
  }
}
