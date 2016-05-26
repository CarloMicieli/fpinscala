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

class OptionTestSpec extends AbstractTestSpec {
  describe("Option") {
    describe("map()") {
      it("should apply a function to Some values") {
        Some(21).map(_ * 2) shouldBe Some(42)
        Some(21).map(identity) shouldBe Some(21)
      }

      it("should produce a None applying a function to None values") {
        Option.none[Int].map(_ * 2) shouldBe None
      }
    }

    describe("flatMap") {
      it("should apply a function to Some values and flatten the result") {
        Some(21).flatMap(x => Some(x * 2)) shouldBe Some(42)
      }

      it("should return back a None applying a function to None values") {
        Option.none[Int].flatMap(x => Some(x * 2)) shouldBe None
      }
    }

    describe("getOrElse") {
      it("should return the value wrapped in a Some") {
        Some(42).getOrElse(-1) shouldBe 42
      }

      it("should return the default value for None") {
        None.getOrElse(-1) shouldBe -1
      }
    }

    describe("orElse") {
      it("should return the value wrapped in a Some") {
        Some(42).orElse(Some(-1)) shouldBe Some(42)
      }

      it("should return the default value for None") {
        None.getOrElse(Some(-1)) shouldBe Some(-1)
      }
    }

    describe("filter") {
      it("should return the Some value if it matches the predicate") {
        Some(42).filter(_ % 2 == 0) shouldBe Some(42)
      }

      it("should return None if the Some value is not matching the predicate") {
        Some(41).filter(_ % 2 == 0) shouldBe None
      }

      it("should return None if the None value is not matching the predicate") {
        Option.none[Int].filter(_ % 2 == 0) shouldBe None
      }
    }
  }
}
