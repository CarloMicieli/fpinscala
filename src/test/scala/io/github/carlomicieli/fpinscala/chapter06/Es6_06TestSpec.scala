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

class Es6_06TestSpec extends Chapter6Spec with Es6_06 {
  describe("Es6.6") {
    it("should combine two random generators") {
      val ((i, d), _) = map2(_.nextInt, _.nextDouble)((a, b) => (a, b))(simpleRNG)
      i shouldBe 16159453
      d shouldBe 0.5967354856416283
    }
  }
}