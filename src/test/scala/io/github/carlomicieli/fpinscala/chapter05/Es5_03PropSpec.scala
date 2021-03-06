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

package io.github.carlomicieli.fpinscala.chapter05

import org.scalacheck.Gen
import org.scalacheck.Prop.{ forAll, AnyOperators }
import io.github.carlomicieli.AbstractPropSpec

class Es5_03PropSpec extends AbstractPropSpec with Es5_03 {
  property("takeWhile and dropWhile results appended produce back all the initial stream elements") {
    check(forAll(functions) { (p: Int => Boolean) =>
      forAll { (s: Stream[Int]) =>
        val s2 = takeWhile(s)(p) append dropWhile(s)(p)
        s2 ?= s
      }
    })
  }

  val isOdd: Int => Boolean = _ % 2 == 1
  val isEven: Int => Boolean = _ % 2 == 0
  val isPositive: Int => Boolean = _ >= 0
  val isNegative: Int => Boolean = _ < 0

  val functions: Gen[Int => Boolean] = Gen.oneOf(isOdd, isEven, isPositive, isNegative)
}
