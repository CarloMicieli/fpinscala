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
package io.github.carlomicieli.fpinscala.chapter02

import io.github.carlomicieli.AbstractPropSpec
import org.scalacheck.Prop.forAll
import org.scalacheck.Gen._

class Es2_2PropSpec extends AbstractPropSpec with Es2_2 {

  property("isSorted: should check whether two elements arrays are sorted") {
    check(forAll { (x: Int, y: Int) =>
      val a = Array(x, y)
      isSorted[Int](a, _ <= _) === (x <= y)
    })
  }

  property("isSorted: should return the negate result reversing a sorted array") {
    check(forAll(posNum[Int]) { (x: Int) =>
      val xs = (0 to x).toArray
      isSorted[Int](xs, _ <= _) !== isSorted[Int](xs.reverse, _ <= _)
    })
  }

  property("isSorted: should return false for unsorted arrays") {
    check(forAll(nonEmptyArray[Int], posIntArray) { (xs: Array[Int], ys: Array[Int]) =>
      val array = xs ++ Array(42, -42) ++ ys
      isSorted[Int](array, _ <= _) === false
    })
  }
}
