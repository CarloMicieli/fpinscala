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

import java.util.NoSuchElementException

import io.github.carlomicieli.AbstractTestSpec

class ListTestSpec extends AbstractTestSpec with SampleLists {
  describe("A List") {
    describe("toString") {
      it("should produce a string representation") {
        list.toString shouldBe "[1, 2, 3, 4]"
        List.empty[Int].toString shouldBe "[]"
      }
    }

    describe("equals") {
      it("should equals lists") {
        list.equals(list) shouldBe true
        emptyList.equals(emptyList) shouldBe true
        emptyList.equals(list) shouldBe false
        list.equals(emptyList) shouldBe false
      }
    }

    describe("apply") {
      it("should find an element by its index") {
        listFrom1to10(1) shouldBe Some(2)
        listFrom1to10(100) shouldBe None
        listFrom1to10(-1) shouldBe None
      }
    }

    describe("emptyList") {
      it("should throw an exception for head") {
        the[NoSuchElementException] thrownBy {
          emptyList.head
        } should have message "Nil.head"
      }

      it("should throw an exception for tail") {
        the[NoSuchElementException] thrownBy {
          emptyList.tail
        } should have message "Nil.tail"
      }
    }
  }
}
