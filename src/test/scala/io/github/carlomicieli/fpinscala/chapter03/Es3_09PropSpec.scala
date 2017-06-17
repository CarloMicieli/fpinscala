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

class Es3_09PropSpec extends AbstractPropSpec with Es3_09 {
  property("length(): should work like the list implementation") {
    check(forAll { (xs: List[Int]) =>
      length(xs).toLong ?= xs.length
    })
  }

  property("length(): results in a non negative value") {
    check(forAll { (xs: List[Int]) =>
      length(xs) >= 0
    })
  }

  property("length(): cons increases the length by 1") {
    check(forAll { (xs: List[Int], x: Int) =>
      length(xs) + 1 ?= length(Cons(x, xs))
    })
  }

  property("length(): appending two non empty lists will produce twice the original list length") {
    check(forAll(nonEmptyList[Int]) { (xs: List[Int]) =>
      length(xs) * 2 ?= length(xs append xs)
    })
  }
}
