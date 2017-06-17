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

class Es3_10TestSpec extends Chapter3Spec with Es3_10 {
  describe("Es3.10") {
    describe("foldRight") {
      it("is not stack-safe: it should blow the stack with long lists") {
        the[StackOverflowError] thrownBy {
          blowTheStack()
        }
      }

      it("is tail call optimized: it won't blow the stack") {
        stackSafeCount() shouldBe 500000500000L
      }

      it("should return the initial value for the empty list") {
        foldRight(emptyList, 42)((x, xs) => x + xs) shouldBe 42
      }
    }
  }
}
