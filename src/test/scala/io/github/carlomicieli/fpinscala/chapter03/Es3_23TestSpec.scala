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

class Es3_23TestSpec extends Chapter3Spec with Es3_23 {
  describe("Es3.23") {
    it("should apply a function to corresponding elements in two lists") {
      zipWith(List(1, 2, 3), List(4, 5, 6))(_ + _) shouldBe List(5, 7, 9)
      zipWith(List("1", "2", "3"), List("4", "5", "6"))(_ + _) shouldBe List("14", "25", "36")
    }

    it("should produce a list with the same number of elements as the shortest list") {
      zipWith(List(1, 2), List(4, 5, 6))(_ + _) shouldBe List(5, 7)
      zipWith(List(1, 2, 3), List(4, 5))(_ + _) shouldBe List(5, 7)
      zipWith(List(1, 2), Nil)(_ + _) shouldBe Nil
      zipWith(Nil, List(4, 5, 6))(_ + _) shouldBe Nil
    }
  }

}
