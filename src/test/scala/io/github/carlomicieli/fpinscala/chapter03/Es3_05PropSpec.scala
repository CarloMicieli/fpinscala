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

package io.github.carlomicieli.fpinscala.chapter03

import org.scalacheck.Prop.{ forAll, AnyOperators }
import io.github.carlomicieli.AbstractPropSpec

class Es3_05PropSpec extends AbstractPropSpec with Es3_05 {
  property("dropWhile(): shouldn't increase size length") {
    check(forAll { (xs: List[Int]) =>
      dropWhile(xs)(greaterThan42).length <= xs.length
    })
  }

  property("dropWhile(): should leave the list unchanged if the head doesn't match the predicate") {
    check(forAll(nonEmptyList[Int]) { (xs: List[Int]) =>
      val ys = dropWhile(xs)(_ > xs.head)
      ys ?= xs
    })
  }

  property("dropWhile(): should drop the head if matches the predicate") {
    check(forAll(nonEmptyList[Int]) { (xs: List[Int]) =>
      val ys = dropWhile(xs)(_ == xs.head)
      ys.isEmpty || ys.head != xs.head
    })
  }

  property("dropWhile(): the first element in the resulting list, if non empty shouldn't match the predicate") {
    check(forAll { (xs: List[Int]) =>
      val ys = dropWhile(xs)(greaterThan42)
      ys.isEmpty || !greaterThan42(ys.head)
    })
  }

  val greaterThan42: Int => Boolean = _ > 42
}
