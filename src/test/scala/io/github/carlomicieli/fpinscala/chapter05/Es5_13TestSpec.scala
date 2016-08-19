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

class Es5_13TestSpec extends AbstractTestSpec with Es5_13 with SampleStreams {
  describe("Es5.13") {
    describe("map") {
      it("should implement map in terms of unfold") {
        val s = Stream.fromRange(1 until 5)
        map(s)(_ * 2) shouldBe Stream(2, 4, 6, 8)
        map(Stream.from(1))(_ * 2).take(4) shouldBe Stream(2, 4, 6, 8)
      }
    }

    describe("take") {
      it("should implement take in terms of unfold") {
        val s = Stream.fromRange(1 until 5)
        take(s)(3) shouldBe Stream(1, 2, 3)
        take(Stream.from(1))(3) shouldBe Stream(1, 2, 3)
      }
    }

    describe("takeWhile") {
      it("should implement takeWhile in terms of unfold") {
        val s = Stream.fromRange(1 until 5)
        takeWhile(s)(_ < 4) shouldBe Stream(1, 2, 3)
        takeWhile(Stream.from(1))(_ < 4) shouldBe Stream(1, 2, 3)
      }
    }

    describe("zipWith") {
      it("should implement zipWith in terms of unfold") {
        val s1 = Stream.fromRange(1 until 5)
        val s2 = Stream.fromRange(1 until 5)
        zipWith(s1, s2)(_ * _) shouldBe Stream(1, 4, 9, 16)
        zipWith(s1, Stream.from(1))(_ * _) shouldBe Stream(1, 4, 9, 16)
      }
    }

    describe("zipAll") {
      ignore("should zipAll elements for two streams") {
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