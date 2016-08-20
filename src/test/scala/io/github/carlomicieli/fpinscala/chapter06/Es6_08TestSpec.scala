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

class Es6_08TestSpec extends Chapter6Spec with Es6_08 {
  describe("Es6.8") {
    it("should produce non negative numbers") {
      val (n, rng) = nonNegativeLessThan(100)(simpleRNG)
      val (n2, _) = nonNegativeLessThan(100)(rng)
      n shouldBe 53
      n2 shouldBe 97
    }
  }
}
