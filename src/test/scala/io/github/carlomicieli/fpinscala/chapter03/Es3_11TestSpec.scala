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

class Es3_11TestSpec extends Chapter3Spec with Es3_11 {
  describe("Es3.11") {
    it("should sum the list elements") {
      sum(listFrom1to10) shouldBe 55
      sum(List.empty[Double]) shouldBe 0.0
    }

    it("should make the product of the list elements") {
      product(listFrom1to10) shouldBe 3628800
      product(List.empty[Double]) shouldBe 1.0
    }

    it("should find the list length") {
      length(listFrom1to10) shouldBe 10
      length(Nil) shouldBe 0
    }
  }
}
