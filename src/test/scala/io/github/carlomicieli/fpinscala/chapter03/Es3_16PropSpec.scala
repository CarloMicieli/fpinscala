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

import org.scalacheck.Gen._
import org.scalacheck.Prop.{ forAll, AnyOperators }
import io.github.carlomicieli.AbstractPropSpec

class Es3_16PropSpec extends AbstractPropSpec with Es3_16 {
  property("addOne(): should increase the list sum by the list length") {
    check(forAll(posNum[Int]) { (x: Int) =>
      val xs: List[Int] = List.fill(x)(42)
      sum(addOne(xs)) ?= xs.length + sum(xs)
    })
  }

  property("addOne(): sum should be greater or equals than original list sum") {
    check(forAll(posNum[Int]) { (x: Int) =>
      val xs: List[Int] = List.fill(x)(42)
      sum(addOne(xs)) >= sum(xs)
    })
  }

  property("addOne() should leave unchanged the list length") {
    check(forAll { (xs: List[Int]) =>
      addOne(xs).length ?= xs.length
    })
  }

  private val sum: (List[Int] => Long) = _.foldLeft(0L)(_ + _)
}
