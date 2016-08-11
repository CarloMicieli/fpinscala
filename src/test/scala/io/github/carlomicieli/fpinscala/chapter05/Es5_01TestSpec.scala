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

class Es5_01TestSpec extends AbstractTestSpec {
  describe("Es5.1") {
    describe("toList") {
      it("should produce the empty list from the empty stream") {
        Stream.empty[Int].toList shouldBe List.empty[Int]
      }

      it("should produce a list with the same length as the original stream") {
        Stream(1, 2, 3, 4).toList shouldBe List(1, 2, 3, 4)
      }
    }
  }
}
