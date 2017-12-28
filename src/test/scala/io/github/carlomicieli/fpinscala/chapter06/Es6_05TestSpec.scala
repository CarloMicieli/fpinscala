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

package io.github.carlomicieli.fpinscala.chapter06

class Es6_05TestSpec extends Chapter6Spec with Es6_05 {
  describe("Es6.5") {
    it("should return double values") {
      val (n1, rng) = double(simpleRNG)
      n1 shouldBe 0.007524831689672932

      val (n2, _) = double(rng)
      n2 shouldBe 0.5967354856416283
    }
  }
}
