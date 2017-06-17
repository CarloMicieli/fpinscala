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

class Es3_20PropSpec extends AbstractPropSpec with Es3_20 {
  property("flatMap(): should apply the function and flat the result") {
    check(forAll(nonEmptyList[Int]) { (xs: List[Int]) =>
      flatMap(xs)(x => List(x, x)).length ?= xs.length * 2
    })
  }

  property("flatMap(): identity law") {
    check(forAll { (cs: List[Char]) =>
      flatMap(cs)(f) ?= cs
    })
  }

  property("flatMap() is the same as applying map and then flatten") {
    check(forAll { (cs: List[Char]) =>
      flatMap(cs)(g).toScalaList ?= cs.toScalaList.map(g).flatten
    })
  }

  val f: Char => List[Char] = List(_)
  val g: Char => List[Char] = c => List('a', 'b', c)
}
