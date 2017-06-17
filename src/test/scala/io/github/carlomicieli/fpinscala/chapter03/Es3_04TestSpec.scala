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

package io.github.carlomicieli.fpinscala.chapter03

class Es3_04TestSpec extends Chapter3Spec with Es3_04 {
  describe("Es3.4: drop()") {
    it("should drop the first n elements from a list") {
      drop(list, 2) shouldBe List(3, 4)
    }

    it("should return the same list when dropping 0 elements") {
      drop(list, 0) shouldBe list
    }

    it("should return the empty list when dropping n elements from the empty list") {
      drop(Nil, 4) shouldBe Nil
    }

    it("should return the empty list when the number of dropped elements is more the list length") {
      drop(list, list.length.toInt + 1) shouldBe Nil
    }

    it("should return the original list dropping a negative number of elements") {
      drop(list, -2) shouldBe list
    }
  }
}
