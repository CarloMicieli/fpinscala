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

class Es3_06PropSpec extends AbstractPropSpec with Es3_06 {
  property("init(): should keep the head unchanged for non empty lists") {
    check(forAll(nonEmptyList[Int]) { (xs: List[Int]) =>
      val ys = init(xs)
      ys.isEmpty || (ys.head == xs.head)
    })
  }

  property("init(): should reduce list length by at most one") {
    check(forAll(nonEmptyList[Int]) { (xs: List[Int]) =>
      val ys = init(xs)
      ys.length ?= xs.length - 1
    })
  }
}
