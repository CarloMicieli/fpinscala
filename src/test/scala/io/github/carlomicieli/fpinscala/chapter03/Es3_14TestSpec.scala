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

package io.github.carlomicieli.fpinscala.chapter03

class Es3_14TestSpec extends Chapter3Spec with Es3_14 {
  describe("Es3.14") {
    it("should append two lists") {
      val a = List(1, 2, 3)
      val b = List(4, 5, 6)
      append(a, b) shouldBe List(1, 2, 3, 4, 5, 6)
      append(Nil, b) shouldBe b
      append(a, Nil) shouldBe a
      append(Nil, Nil) shouldBe Nil
    }

    it("should append two lists (left version)") {
      val a = List(1, 2, 3)
      val b = List(4, 5, 6)
      appendL(a, b) shouldBe List(1, 2, 3, 4, 5, 6)
      appendL(Nil, b) shouldBe b
      appendL(a, Nil) shouldBe a
      appendL(Nil, Nil) shouldBe Nil
    }

    it("should append two lists (right version)") {
      val a = List(1, 2, 3)
      val b = List(4, 5, 6)
      appendR(a, b) shouldBe List(1, 2, 3, 4, 5, 6)
      appendR(Nil, b) shouldBe b
      appendR(a, Nil) shouldBe a
      appendR(Nil, Nil) shouldBe Nil
    }
  }
}
