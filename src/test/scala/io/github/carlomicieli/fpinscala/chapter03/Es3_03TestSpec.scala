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

class Es3_03TestSpec extends AbstractTestSpec with Es3_03 with SampleLists {
  describe("Es3.3") {
    it("should replace the head of a list") {
      val NewHead = 42
      val l = setHead(NewHead, list)
      l.head shouldBe NewHead
    }

    it("should throw an exception for the empty list") {
      val thrown = the[NoSuchElementException] thrownBy {
        setHead(42, List.empty[Int])
      } should have message "Nil.setHead: list is empty"
    }
  }
}
