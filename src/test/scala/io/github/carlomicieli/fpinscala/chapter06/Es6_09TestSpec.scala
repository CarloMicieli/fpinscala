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

import io.github.carlomicieli.fpinscala.chapter06.RNG.int

class Es6_09TestSpec extends Chapter6Spec with Es6_09 {
  describe("Es6.9") {
    it("should implement map in terms of flatMap") {
      val (n, _) = int(simpleRNG)
      val (n2, _) = map(int)(_ * 2)(simpleRNG)

      n2 shouldBe n * 2
    }

    it("should implement map2 in terms of flatMap") {
      val (n1, rng2) = int(simpleRNG)
      val (n2, _) = int(rng2)

      val (n3, _) = map2(int, int)(_ - _)(simpleRNG)
      n1 - n2 shouldBe n3
    }
  }
}
