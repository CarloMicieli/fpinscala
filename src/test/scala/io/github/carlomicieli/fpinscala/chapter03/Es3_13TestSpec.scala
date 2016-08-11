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

package io.github.carlomicieli.fpinscala.chapter03

import io.github.carlomicieli.AbstractTestSpec

class Es3_13TestSpec extends AbstractTestSpec with Es3_13 with SampleLists {
  describe("Es3.13") {
    describe("foldLeft via foldRight") {
      it("should work like a foldLeft function") {
        val xs = listFrom1to10
        val f = (acc: String, x: Int) => s"f($acc, $x)"
        foldLeft(xs, "z")(f) shouldBe xs.foldLeft("z")(f)
      }
    }

    describe("foldRight via foldLeft") {
      it("should work like a foldRight function") {
        val xs = listFrom1to10
        val f = (x: Int, acc: String) => s"f($acc, $x)"
        foldRight(xs, "z")(f) shouldBe xs.foldRight("z")(f)
      }
    }
  }
}
