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

package io.github.carlomicieli.fpinscala.chapter06

class Es6_01TestSpec extends Chapter6Spec with Es6_01 {
  describe("Es6.1") {
    it("should produce non negative random numbers") {
      val (n1, _) = nonNegativeInt(simpleRNG)
      n1 should be >= 0

      val (n2, _) = nonNegativeInt(simpleRNG)
      n2 should be >= 0
    }
  }
}

