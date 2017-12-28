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

class Es3_20TestSpec extends Chapter3Spec with Es3_20 {
  describe("Es3.20") {
    it("should apply a function to each list element and then flatten the result") {
      val f = (i: Int) => List(i, i + 10)

      flatMap(List.empty[Int])(f) shouldBe Nil
      flatMap(List(1, 2, 3))(f) shouldBe List(1, 11, 2, 12, 3, 13)
    }
  }
}
