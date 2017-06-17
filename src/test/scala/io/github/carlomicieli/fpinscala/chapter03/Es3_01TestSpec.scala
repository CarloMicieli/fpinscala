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

class Es3_01TestSpec extends Chapter3Spec with Es3_01 {
  describe("Es3.01") {
    it("should evaluate to 3") {
      apply(List(1, 2, 3, 4, 5)) shouldBe 3
    }

    it("should evaluate to 42") {
      apply(Nil) shouldBe 42
    }

    it("should evaluate to 1") {
      apply(List(1, 2, 4, 5)) shouldBe 1
    }

    it("should evaluate to 18") {
      apply(List(1, 9, 8)) shouldBe 18
    }
  }
}
