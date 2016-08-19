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

package io.github.carlomicieli.fpinscala.chapter05

import io.github.carlomicieli.AbstractTestSpec

class Es5_07TestSpec extends AbstractTestSpec with Es5_07 with SampleStreams {
  describe("Es5.7") {
    describe("map") {
      it("should implement map using foldRight") {
        val f: Int => Int = _ * 2
        val s = Stream(1, 2, 3, 4)

        map(s)(f) shouldBe Stream(2, 4, 6, 8)
        map(Stream.enumFrom(1)(_ + 1))(f).take(2) shouldBe Stream(2, 4)
      }
    }

    describe("filter") {
      it("should implement filter using foldRight") {
        val f: Int => Boolean = _ % 2 == 0
        val s = Stream(1, 2, 3, 4)

        filter(s)(f) shouldBe Stream(2, 4)
        filter(Stream.enumFrom(42)(_ + 1))(f).take(5) shouldBe Stream(42, 44, 46, 48, 50)
      }
    }

    describe("flatMap") {
      it("should implement flatMap using foldRight") {
        val s1 = Stream(1, 2, 3, 4)
        val s2 = Stream.enumFrom(5)(_ + 1)

        val f: Int => Stream[Int] = x => Stream(2 * x)

        flatMap(s1)(f) shouldBe Stream(2, 4, 6, 8)
        // flatMap(s2)(f).take(5) shouldBe Stream(10, 12, 14, 16, 18)
      }
    }

    describe("append") {
      it("should append two streams using foldRight") {
        val s1 = Stream(1, 2, 3, 4)
        val s2 = Stream.enumFrom(5)(_ + 1)

        def error: Stream[Int] = throw new NoSuchElementException("")

        append(s1, s2).take(5) shouldBe Stream.fromRange(1 to 5)
        append(s2, s1).take(5) shouldBe Stream.fromRange(5 until 10)
        append(s2, s2).take(5) shouldBe Stream.fromRange(5 until 10)
        append(s2, error).take(5) shouldBe Stream.fromRange(5 until 10)
      }
    }
  }
}
