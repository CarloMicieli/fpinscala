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

class Es3_09TestSpec extends AbstractTestSpec with Es3_09 with SampleLists {
  describe("Es3.9: length") {
    it("should calculate the length of the empty list") {
      length(emptyList) shouldBe 0
    }

    it("should calculate the length of a list") {
      length(listFrom1to10) shouldBe 10
    }
  }
}