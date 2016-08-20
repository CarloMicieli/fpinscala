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

package io.github.carlomicieli.fpinscala.chapter04

import io.github.carlomicieli.AbstractTestSpec
import Option._

class Es4_03TestSpec extends AbstractTestSpec with Es4_03 {
  describe("Es4.3") {
    describe("map2()") {
      it("should map over two Option values") {
        val some1 = some(40)
        val some2 = some(2)
        val noneV = none[Int]

        val f = (x: Int, y: Int) => x + y

        map2(some1, some2)(f) shouldBe some(42)
        map2(some1, noneV)(f) shouldBe noneV
        map2(noneV, some2)(f) shouldBe noneV
      }
    }
  }
}
