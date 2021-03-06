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

package io.github.carlomicieli.fpinscala.chapter02

import io.github.carlomicieli.AbstractTestSpec

class Es2_3TestSpec extends AbstractTestSpec with Es2_3 {
  describe("curry()") {
    it("should produce curried functions") {
      val sum: (Int, Int) => Int = _ + _
      val f = curry(sum)

      f(21)(21) shouldBe sum(21, 21)
    }
  }
}
