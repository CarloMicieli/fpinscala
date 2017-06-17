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

import io.github.carlomicieli.AbstractTestSpec

class Es3_29TestSpec extends AbstractTestSpec with Es3_29 {
  describe("Es3.29") {
    it("should implement depth with fold") {
      val t1 = Leaf(42)
      val t2 = Branch(Branch(Leaf(1), Leaf(2)), Leaf(3))
      depth(t1) shouldBe 0
      depth(t2) shouldBe 2
    }

    it("should implement maximum with fold") {
      val t1 = Leaf(42)
      val t2 = Branch(Branch(Leaf(1), Leaf(2)), Leaf(3))
      maximum(t1) shouldBe 42
      maximum(t2) shouldBe 3
    }

    it("should implement size with fold") {
      val t1 = Leaf(42)
      val t2 = Branch(Branch(Leaf(1), Leaf(2)), Leaf(3))
      size(t1) shouldBe 1
      size(t2) shouldBe 3
    }

    it("should implement map with fold") {
      val t1 = Branch(Branch(Leaf(1), Leaf(2)), Leaf(3))
      map(t1, (x: Int) => x * 2) shouldBe Branch(Branch(Leaf(2), Leaf(4)), Leaf(6))
    }
  }

}
