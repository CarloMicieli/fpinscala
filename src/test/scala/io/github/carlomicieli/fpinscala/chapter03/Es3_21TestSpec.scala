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

package io.github.carlomicieli.fpinscala.chapter03

class Es3_21TestSpec extends Chapter3Spec with Es3_21 {
  describe("Es3.21") {
    it("should implement filter with flatMap") {
      filter(List(1, 2, 3, 4, 5))(_ % 2 == 0) shouldBe List(2, 4)
      filter(List.empty[Int])(_ % 2 == 0) shouldBe Nil
    }
  }
}
