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

package io.github.carlomicieli.fpinscala.chapter04

import org.scalacheck.Prop.{ forAll, AnyOperators }
import io.github.carlomicieli.AbstractPropSpec

class EitherPropSpec extends AbstractPropSpec {
  property("map(): identity law") {
    check(forAll { (e: Either[String, Int]) =>
      e.map(identity) ?= e
    })
  }

  property("map(): composition law") {
    check(forAll { (e: Either[String, Int]) =>
      val plusOne: Int => Int = _ + 1
      val twoTimes: Int => Int = _ * 2
      e.map(plusOne compose twoTimes) ?= e.map(twoTimes).map(plusOne)
    })
  }

  property("flatMap(): identity law") {
    check(forAll { (e: Either[String, Int]) =>
      e.flatMap(x => e) ?= e
    })
  }

  property("flatMap(): apply function to right values only") {
    check(forAll { (e: Either[String, Int]) =>
      val res = e.flatMap(x => Either.right(x * 2))
      e.isRight ?= res.isRight
      e.isLeft ?= res.isLeft
    })
  }

  property("orElse(): return the original value if it's a Right") {
    check(forAll { (e: Either[String, Int]) =>
      val res = e.orElse(Either.right(42))
      res.isRight
      if (e.isRight) {
        res ?= e
      } else {
        res ?= Either.right(42)
      }
    })
  }

  property("map2(): producing a Right if both the values are Right") {
    check(forAll { (e1: Either[String, Int], e2: Either[String, Int]) =>
      {
        val res = e1.map2(e2)(_ + _)
        if (e1.isRight && e2.isRight) {
          res.isRight
        } else {
          res.isLeft
        }
      }
    })
  }
}
