// Copyright (C) 2016 the original author or authors.
// See the LICENCE.txt file distributed with this work for additional
// information regarding copyright ownership.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package io.github.carlomicieli.fpinscala.chapter02

import io.github.carlomicieli.AbstractTestSpec

class Es2_2TestSpec extends AbstractTestSpec with Es2_2 {
  describe("Es2.2: isSorted()") {
    it("should return true for empty arrays") {
      isSorted(Array.empty[Int], ord) shouldBe true
    }

    it("should return true for singleton arrays") {
      isSorted(Array(42), ord) shouldBe true
    }

    it("should return true for arrays filled with the same element") {
      val a = Array.fill(100)(42)
      isSorted(a, ord) shouldBe true
    }

    it("should return true for sorted arrays") {
      val a = (1 to 100).toArray
      isSorted(a, ord) shouldBe true
    }

    it("should return false for unsorted arrays") {
      val a = (1 to 100).reverse.toArray
      isSorted(a, ord) shouldBe false
    }
  }

  val ord: (Int, Int) => Boolean = _ <= _
}
