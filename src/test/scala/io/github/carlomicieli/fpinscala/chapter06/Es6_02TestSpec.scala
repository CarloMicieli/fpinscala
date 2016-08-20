/*
 * Copyright 2016 Carlo Micieli
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

class Es6_02TestSpec extends Chapter6Spec with Es6_02 {
  describe("Es6.2") {
    it("should produce double number between 0 and 1") {
      val (d, _) = double(simpleRNG)
      d should (be >= 0.0 and be < 1.0)
      d should equal(0.00752 +- 0.00001)
    }
  }
}
