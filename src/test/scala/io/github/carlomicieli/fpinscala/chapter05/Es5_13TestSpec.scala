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

class Es5_13TestSpec extends Chapter5Spec with Es5_13 {
  describe("Es5.13") {
    describe("map") {
      it("should implement map in terms of unfold for finite streams") {
        map(streamFrom(1 until 5))(_ * 2) shouldBe Stream(2, 4, 6, 8)
      }

      it("should implement map in terms of unfold for infinite streams") {
        map(Stream.from(1))(_ * 2).take(4) shouldBe Stream(2, 4, 6, 8)
      }
    }

    describe("take") {
      it("should implement take in terms of unfold for finite streams") {
        take(streamFrom(1 until 5))(3) shouldBe Stream(1, 2, 3)
      }

      it("should implement take in terms of unfold for infinite streams") {
        take(infiniteStream)(3) shouldBe Stream(0, 1, 2)
      }
    }

    describe("takeWhile") {
      it("should implement takeWhile in terms of unfold for finite stream") {
        takeWhile(streamFrom(1 until 5))(_ < 4) shouldBe Stream(1, 2, 3)
      }

      it("should implement takeWhile in terms of unfold for infinite stream") {
        takeWhile(infiniteStream)(_ < 4) shouldBe Stream(0, 1, 2, 3)
      }
    }

    describe("zipWith") {
      it("should implement zipWith in terms of unfold for finite streams") {
        zipWith(streamFrom(1 until 5), streamFrom(1 until 5))(_ * _) shouldBe Stream(1, 4, 9, 16)
      }

      it("should implement zipWith in terms of unfold for infinite streams") {
        zipWith(streamFrom(1 to 5), infiniteStream)(_ * _) shouldBe Stream(0, 2, 6, 12, 20)
        zipWith(infiniteStream, streamFrom(1 to 5))(_ * _) shouldBe Stream(0, 2, 6, 12, 20)
      }
    }

    describe("zipAll") {
      it("should zipAll elements for two streams") {
        val s1 = Stream(1, 2)
        val s2 = Stream(1, 2, 3)
        zipAll(s1, s2) shouldBe Stream.fromValues((Some(1), Some(1)), (Some(2), Some(2)), (None, Some(3)))
        zipAll(s2, s1) shouldBe Stream.fromValues((Some(1), Some(1)), (Some(2), Some(2)), (Some(3), None))

        val s3 = Stream.from(42)
        val s4 = Stream(1)
        zipAll(s3, s4).take(3) shouldBe Stream((Some(42), Some(1)), (Some(43), None), (Some(44), None))

      }
    }
  }
}