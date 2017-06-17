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

package io.github.carlomicieli.fpinscala.chapter06

class Es6_04TestSpec extends Chapter6Spec with Es6_04 {
  describe("Es6.4") {
    it("should produce a list of random numbers") {
      val (num, _) = ints(5)(simpleRNG)
      num shouldBe List(1770001318, -2015756020, -340305902, -1281479697, 16159453)
    }
  }
}
