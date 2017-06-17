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

package io.github.carlomicieli.fpinscala.chapter05

class Es5_07TestSpec extends Chapter5Spec with Es5_07 {
  describe("Es5.7") {
    describe("map") {
      it("should implement map using foldRight for finite streams") {
        val f: Int => Int = _ * 2
        map(streamFrom(1 to 4))(f) shouldBe Stream(2, 4, 6, 8)
      }

      it("should implement map using foldRight for infinite streams") {
        val f: Int => Int = _ * 2
        map(infiniteStream)(f).take(3) shouldBe Stream(0, 2, 4)
      }
    }

    describe("filter") {
      it("should implement filter using foldRight for finite streams") {
        val f: Int => Boolean = _ % 2 == 0
        filter(streamFrom(1 to 4))(f) shouldBe Stream(2, 4)
      }

      it("should implement filter using foldRight for infinite streams") {
        val f: Int => Boolean = _ % 2 == 0
        filter(infiniteStream)(f).take(5) shouldBe Stream(0, 2, 4, 6, 8)
      }
    }

    describe("flatMap") {
      it("should implement flatMap using foldRight for finite streams") {
        val f: Int => Stream[Int] = x => Stream(2 * x)
        flatMap(streamFrom(1 to 4))(f) shouldBe Stream(2, 4, 6, 8)
      }

      it("should implement flatMap using foldRight for infinite streams") {
        val f: Int => Stream[Int] = x => Stream(2 * x)
        flatMap(infiniteStream)(f).take(5) shouldBe Stream(0, 2, 4, 6, 8)
      }
    }

    describe("append") {
      it("should append two streams using foldRight for finite streams") {
        append(streamFrom(1 to 5), streamFrom(6 to 10)) shouldBe streamFrom(1 to 10)
      }

      it("should append two streams using foldRight for infinite streams") {
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
