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

import io.github.carlomicieli.AbstractPropSpec
import org.scalacheck.Prop.{ forAll, AnyOperators }

class Es3_03PropSpec extends AbstractPropSpec with Es3_03 {
  property("setHead: it shouldn't increase the list length") {
    check(forAll(nonEmptyList[Int]) { (xs: List[Int]) =>
      setHead(0, xs).length ?= xs.length
    })
  }

  property("setHead: it should replace the head") {
    check(forAll { (x: Int, xs: List[Int]) =>
      val list = Cons(x, xs)
      setHead(x + 1, list).head ?= x + 1
    })
  }
}
