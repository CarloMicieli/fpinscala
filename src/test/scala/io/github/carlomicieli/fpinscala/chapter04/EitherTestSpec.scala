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

package io.github.carlomicieli.fpinscala.chapter04

import io.github.carlomicieli.AbstractTestSpec

class EitherTestSpec extends AbstractTestSpec {
  val right: Either[String, Int] = Right(42)
  val left: Either[String, Int] = Left("no answer")

  describe("Either") {
    it("should create Left or Right values") {
      Right(42).value shouldBe 42
      Left("no answer").value shouldBe "no answer"
    }

    describe("map()") {
      it("should apply a function to Left values") {
        left.map(_ * 2) shouldBe Left("no answer")
      }

      it("should apply a function to Right values") {
        right.map(_ * 2) shouldBe Right(84)
      }
    }

    describe("flatMap()") {
      it("should apply a function to Left values") {
        val f = (x: Int) => if (x > 0) Right(x * 2) else Left("wrong")
        left.flatMap(f) shouldBe left
      }

      it("should apply a function to Right values") {
        val f = (x: Int) => if (x > 0) Right(x * 2) else Left("wrong")
        right.flatMap(f) shouldBe Right(84)
      }
    }

    describe("orElse()") {
      it("should return an alternative value for Left values") {
        left.orElse(Right(0)) shouldBe Right(0)
      }

      it("should return the original value for Right values") {
        right.orElse(Right(0)) shouldBe right
      }
    }

    describe("map2()") {
      it("should combine two Either values") {
        val r1: Either[String, Int] = Right(21)
        val r2: Either[String, Int] = Right(2)
        val l: Either[String, Int] = Left("no answer")

        r1.map2(r2)(_ * _) shouldBe Right(42)
        r1.map2(l)(_ * _) shouldBe Left("no answer")
        l.map2(r2)(_ * _) shouldBe Left("no answer")
      }
    }
  }
}
