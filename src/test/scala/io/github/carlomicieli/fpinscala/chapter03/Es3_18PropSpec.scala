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

package io.github.carlomicieli.fpinscala.chapter03

import org.scalacheck.Prop.{ forAll, AnyOperators }
import io.github.carlomicieli.AbstractPropSpec

class Es3_18PropSpec extends AbstractPropSpec with Es3_18 {
  property("map(): identity law") {
    check(forAll { (cs: List[Char]) =>
      map(cs)(identity) ?= cs
    })
  }

  property("map(): composition law") {
    check(forAll { (xs: List[Int]) =>
      val f: Int => Int = _ * 2
      val g: Int => Int = _ - 42

      map(map(xs)(g))(f) ?= map(xs)(f compose g)
      map(map(xs)(f))(g) ?= map(xs)(f andThen g)
    })
  }

  property("map(): doesn't change the resulting list length") {
    check(forAll { (cs: List[Char]) =>
      map(cs)(_.toUpper).length ?= cs.length
    })
  }
}
