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

class Es3_23PropSpec extends AbstractPropSpec with Es3_23 {
  property("zipWith(): resulting list length should be as the shortest one") {
    check(forAll { (xs: List[Int], ys: List[Int]) =>
      zipWith(xs, ys)(_ + _).length ?= math.min(xs.length, ys.length)
    })
  }

  property("zipWith(): applying identity works like zip()") {
    check(forAll { (xs: List[Int], ys: List[Int]) =>
      zipWith(xs, ys)((_, _)) ?= zip(xs, ys)
    })
  }

  property("zip(): resulting list length should be as the shortest one") {
    check(forAll { (xs: List[Int], ys: List[Int]) =>
      zip(xs, ys).length ?= math.min(xs.length, ys.length)
    })
  }

}
