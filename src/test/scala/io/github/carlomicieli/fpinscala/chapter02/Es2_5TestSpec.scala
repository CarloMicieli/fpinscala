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

package io.github.carlomicieli.fpinscala.chapter02

import io.github.carlomicieli.AbstractTestSpec

class Es2_5TestSpec extends AbstractTestSpec with Es2_5 {
  describe("compose") {
    it("should compose functions") {
      val doubleMe = (x: Int) => x * 2
      val toString = (x: Int) => s"Number($x)"

      val f = compose(toString, doubleMe)
      val g = andThen(doubleMe, toString)

      f(21) shouldBe g(21)
    }
  }
}
