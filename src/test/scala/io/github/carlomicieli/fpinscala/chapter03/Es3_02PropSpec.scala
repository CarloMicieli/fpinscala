// Copyright (C) 2016 the original author or authors.
// See the LICENCE.txt file distributed with this work for additional
// information regarding copyright ownership.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package io.github.carlomicieli.fpinscala.chapter03

import io.github.carlomicieli.AbstractPropSpec
import org.scalacheck.Prop.{ forAll, AnyOperators }
import org.scalacheck.Gen._

class Es3_02PropSpec extends AbstractPropSpec with Es3_02 {

  property("tail: should return a list with length - 1") {
    check(forAll(nonEmptyList[Int]) { (xs: List[Int]) =>
      tail(xs).length ?= xs.length - 1
    })
  }

  property("tail: should have as the head the second element in the original list") {
    check(forAll(posNum[Int], nonEmptyList[Int]) {
      (x: Int, xs: List[Int]) =>
        val list = Cons(x, xs)
        tail(list).head ?= xs.head
    })
  }

  property("tail: shouldn't remove other elements but the list head") {
    check(forAll(nonEmptyList[Int]) { (xs: List[Int]) =>
      val List(_, rest) = xs
      tail(xs) ?= rest
    })
  }
}
