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
package io.github.carlomicieli.fpinscala.chapter05

import io.github.carlomicieli.AbstractTestSpec

class StreamTestSpec extends AbstractTestSpec with SampleStreams {
  describe("A Stream") {
    describe("headOption") {
      it("should return None for the empty stream") {
        emptyStream.headOption shouldBe None
      }

      it("should return Some for non empty streams") {
        numbersStream.headOption shouldBe Some(1)
      }
    }

    describe("Cons") {
      it("should increase the Stream length by 1") {
        Stream.cons(1, numbersStream).length shouldBe (numbersStream.length + 1)
      }

      it("should change the Stream head") {
        val s = Stream.cons(99, numbersStream)
        s.headOption shouldBe Some(99)
      }
    }

    describe("length") {
      it("should return 0 for the empty stream") {
        emptyStream.length shouldBe 0
      }

      it("should return the number of elements in the stream") {
        numbersStream.length shouldBe 7
      }
    }
  }
}
