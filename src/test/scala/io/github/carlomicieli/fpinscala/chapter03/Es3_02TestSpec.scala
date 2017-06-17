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

class Es3_02TestSpec extends Chapter3Spec with Es3_02 {
  describe("tail") {
    it("should throw an exception for the empty list") {
      the[NoSuchElementException] thrownBy {
        tail(List.empty[Int])
      } should have message "List.tail: list is empty"
    }

    it("should reduce the List length by 1") {
      tail(list).length shouldBe (list.length - 1)
    }

    it("should return Some(tail) when the list is not empty") {
      tailOption(list) shouldBe Some(tail(list))
    }
  }
}
