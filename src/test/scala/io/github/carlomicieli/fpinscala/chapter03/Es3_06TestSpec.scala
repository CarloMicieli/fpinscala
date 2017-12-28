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

class Es3_06TestSpec extends Chapter3Spec with Es3_06 {
  describe("init()") {
    it("should throw an exception when the list is empty") {
      the[NoSuchElementException] thrownBy {
        init(emptyList)
      } should have message "init: list is empty"
    }

    it("should reduce the list length by 1") {
      val xs = init(listFrom1to10)
      xs.length shouldBe listFrom1to10.length - 1
    }

    it("should return all the elements but the last one") {
      val xs = init(listFrom1to10)
      xs shouldBe List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    }
  }
}
