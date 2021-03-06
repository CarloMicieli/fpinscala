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

class Es3_17TestSpec extends Chapter3Spec with Es3_17 {
  describe("Es3.17") {
    describe("convert") {
      it("should convert each list element to string") {
        convert(List(42.0, 44.0)) shouldBe List("42.0", "44.0")
        convert(List.empty[Double]) shouldBe List.empty[String]
      }
    }
  }
}
