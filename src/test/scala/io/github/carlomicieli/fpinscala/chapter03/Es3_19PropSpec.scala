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

import org.scalacheck.Prop.{ forAll, AnyOperators }
import io.github.carlomicieli.AbstractPropSpec

class Es3_19PropSpec extends AbstractPropSpec with Es3_19 {
  property("filter(): returns at most the same number of elements from the original list") {
    check(forAll { (xs: List[Int]) =>
      filter(xs)(_ > 42).length <= xs.length
    })
  }

  property("filter(): removes the elements which are not matching the predicate") {
    check(forAll { (xs: List[Int]) =>
      val ys = filter(xs)(isEven)
      !ys.exists(isOdd)
    })
  }

  property("filter() filtering by a predicate and its negation will produce a list with the same length as the original list") {
    check(forAll { (xs: List[Int]) =>
      (filter(xs)(isOdd) append filter(xs)(isEven)).length ?= xs.length
    })
  }

  val isOdd: Int => Boolean = _ % 2 != 0
  val isEven: Int => Boolean = _ % 2 == 0
}
