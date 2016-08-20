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

package io.github.carlomicieli.fpinscala.chapter06

class Es6_03TestSpec extends Chapter6Spec with Es6_03 {
  describe("Es6.3") {
    it("should produce an integer and a double pair") {
      val ((i, d), _) = intDouble(simpleRNG)
      i shouldBe 16159453
      d shouldBe 0.5967354856416283
    }

    it("should produce a double and an integer pair") {
      val ((d, i), _) = doubleInt(simpleRNG)
      i shouldBe -1281479697
      d shouldBe 0.007524831689672932
    }

    it("should produce three double numbers") {
      val ((d1, d2, d3), _) = double3(simpleRNG)
      d1 shouldBe 0.007524831689672932
      d2 shouldBe 0.5967354856416283
      d3 shouldBe 0.15846728447753344
    }
  }
}