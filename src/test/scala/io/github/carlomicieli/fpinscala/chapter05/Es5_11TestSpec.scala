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

package io.github.carlomicieli.fpinscala.chapter05

class Es5_11TestSpec extends Chapter5Spec with Es5_11 {
  describe("Es5.11") {
    describe("unfold") {
      it("should produce a stream unfolding a function") {
        val f: Int => Option[(Int, Int)] = x => if (x < 5) Some((x * 2, x + 1)) else None
        unfold(0)(f) shouldBe Stream(0, 2, 4, 6, 8)
      }
    }
  }
}
