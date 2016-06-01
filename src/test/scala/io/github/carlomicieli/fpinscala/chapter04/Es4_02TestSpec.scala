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
package io.github.carlomicieli.fpinscala.chapter04

import io.github.carlomicieli.AbstractTestSpec

class Es4_02TestSpec extends AbstractTestSpec with Es4_02 {
  val numbers = Seq(1.0, 5.0, 15.0, 42.0, 52.0, 99.0)
  val emptySeq = Seq.empty[Double]

  describe("Es4.2") {
    describe("variance()") {
      it("should find the variance of a sequence") {
        variance(numbers).getOrElse(0.0) shouldBe 1148.0 +- 1.0
      }

      it("should find the variance for an empty sequence") {
        variance(emptySeq) shouldBe Option.none[Double]
      }
    }

    describe("mean()") {
      it("should find the mean of a sequence") {
        mean(numbers).getOrElse(0.0) shouldBe 36.0 +- 1.0
      }

      it("should find the mean for an empty sequence") {
        mean(emptySeq) shouldBe Option.none[Double]
      }
    }
  }
}
