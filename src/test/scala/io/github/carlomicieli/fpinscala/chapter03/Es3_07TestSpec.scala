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
package io.github.carlomicieli.fpinscala.chapter03

import io.github.carlomicieli.AbstractTestSpec

class Es3_07TestSpec extends AbstractTestSpec with Es3_07 with SampleLists {
  describe("product()") {
    it("should calculate the product") {
      val l1 = List(1, 2, 3, 4, 5, 6, 7)
      val l2 = List(1, 2, 3, 4, 5, 0, 7)
      val l3 = List(1.0, 2.0, 3.0, 4.0, 5.0, 0.0, 7.0)
      product(l1) shouldBe 5040
      product(l2) shouldBe 0
      product(l3) shouldBe 0.0
    }
  }
}
