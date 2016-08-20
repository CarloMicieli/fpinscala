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

class StreamTestSpec extends Chapter5Spec {
  describe("A Stream") {
    describe("fromRange") {
      it("should build a stream from a range") {
        val rangeIncl = 1 to 5
        val rangeEscl = 1 until 5

        Stream.fromRange(rangeIncl) shouldBe Stream(1, 2, 3, 4, 5)
        Stream.fromRange(rangeEscl) shouldBe Stream(1, 2, 3, 4)
      }
    }

    describe("foreach") {
      it("should execute the function for each stream element") {
        var sum = 0
        numbersStream.foreach(x => sum = sum + x)
        sum shouldBe 28
      }

      it("should not run the function for empty streams") {
        var sum = 0
        emptyStream.foreach(x => sum = sum + x)
        sum shouldBe 0
      }
    }

    describe("headOption") {
      it("should return None for the empty stream") {
        emptyStream.headOption shouldBe None
      }

      it("should return Some for non empty streams") {
        numbersStream.headOption shouldBe Some(1)
      }

      it("should not evaluate the tail of the Stream") {
        streamWithUndefinedElement.headOption shouldBe Some(1)
      }
    }

    describe("isEmpty") {
      it("should return true for Empty streams") {
        emptyStream.isEmpty shouldBe true
      }

      it("should return false for non-empty streams") {
        streamWithUndefinedElement.isEmpty shouldBe false
      }
    }

    describe("tail") {
      it("should return the Empty stream when the starting stream is empty") {
        emptyStream.tail shouldBe Stream.empty[Int]
      }

      it("should return the tail") {
        streamWithUndefinedElement.tail.headOption shouldBe Some(2)
      }

      it("should evaluate only the head element") {
        streamWithUndefinedElement.tail.tail.length shouldBe 2
      }
    }

    describe("exists") {
      it("should return false for empty streams") {
        emptyStream.exists(_ == 99) shouldBe false
      }

      it("should return false whether no element match the predicate") {
        numbersStream.exists(_ > 1000) shouldBe false
      }

      it("should return true whether no element match the predicate") {
        numbersStream.exists(_ < 10) shouldBe true
      }
    }

    describe("Cons") {
      it("should increase the Stream length by 1") {
        Stream.cons(1, numbersStream).length shouldBe (numbersStream.length + 1)
      }

      it("should change the Stream head") {
        val s = Stream.cons(99, numbersStream)
        s.headOption shouldBe Some(99)
      }
    }

    describe("length") {
      it("should return 0 for the empty stream") {
        emptyStream.length shouldBe 0
      }

      it("should return the number of elements in the stream") {
        numbersStream.length shouldBe 7
      }
    }

    describe("equals") {
      it("should return true comparing two empty streams") {
        (emptyStream equals emptyStream) shouldBe true
      }

      it("should return true comparing two equal non empty streams") {
        (numbersStream equals numbersStream) shouldBe true
      }

      it("should return false comparing one empty stream with a non empty one") {
        (emptyStream equals numbersStream) shouldBe false
        (numbersStream equals emptyStream) shouldBe false
      }
    }

    describe("foldLeft") {
      it("should return the initial element for empty streams") {
        emptyStream.foldLeft(42)(_ + _) shouldBe 42
      }

      it("should apply the function to all elements") {
        Stream(1, 2, 3, 4, 5).foldLeft(1)(_ * _) shouldBe 120
      }

      it("should produce StackOverflow when the stream is not small") {
        an[StackOverflowError] should be thrownBy {
          Stream.positiveNumbers.take(25000).foldLeft(0)(_ + _)
        }
      }
    }

    describe("foldLeftStrict") {
      it("should be stack safe") {
        Stream.positiveNumbers.take(25000).foldLeftStrict(0)(_ + _) shouldBe 312512500
      }
    }
  }
}
