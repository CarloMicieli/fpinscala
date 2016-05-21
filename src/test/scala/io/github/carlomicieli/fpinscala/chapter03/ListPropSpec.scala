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

import org.scalacheck.Prop.{ forAll, AnyOperators }
import io.github.carlomicieli.AbstractPropSpec

class ListPropSpec extends AbstractPropSpec {

  property("cons: increase the list length by 1") {
    check(forAll { (x: Int, xs: List[Int]) =>
      Cons(x, xs).length ?= xs.length + 1
    })
  }

  property("cons: new element should be the resulting list head") {
    check(forAll { (x: Int, xs: List[Int]) =>
      Cons(x, xs).head ?= x
    })
  }

  property("appended list size is the sum of two original lists length") {
    check(forAll { (xs: List[Int], ys: List[Int]) =>
      (xs append ys).length ?= xs.length + ys.length
    })
  }

  property("length: must return a non negative result") {
    check(forAll { (xs: List[Int]) =>
      xs.length >= 0
    })
  }

  property("length: summing the lengths of two lists is equal to the concatenate lists") {
    check(forAll { (xs: List[Int], ys: List[Int]) =>
      xs.length + ys.length ?= (xs append ys).length
    })
  }

  property("reverse: doesn't change the list length") {
    check(forAll { (xs: List[Int]) =>
      xs.length ?= xs.reverse.length
    })
  }

  property("reverse: doesn't change the list elements") {
    check(forAll { (xs: List[Int]) =>
      xs.reverse.reverse ?= xs
    })
  }

  property("fold: with an associative operation folding left and right yield the same result") {
    check(forAll { (xs: List[Int]) =>
      xs.foldLeft(0)(_ + _) ?= xs.foldRight(0)(_ + _)
    })
  }

}
