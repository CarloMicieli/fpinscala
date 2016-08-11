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

class Es3_24TestSpec extends AbstractTestSpec with Es3_24 {
  describe("Es3.24") {
    it("should check whether a list is a subsequence") {
      val list = List(1, 2, 3, 4)
      val sub1 = List(1, 4)
      val sub2 = List(3, 4, 5)
      val sub3 = List(3, 4)

      hasSubsequence(list, sub1) shouldBe false
      hasSubsequence(list, sub2) shouldBe false
      hasSubsequence(list, sub3) shouldBe true
      hasSubsequence(list, List()) shouldBe true
    }
  }
}
