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
package fpinscala.exercises.chapter02

import org.scalatest.FunSuite
import Es2_2._

class Es2_2Suite extends FunSuite {
  test("the empty array is always sorted") {
    val empty: Array[Int] = new Array(0)
    assert(isSorted(empty, ord))
  }

  test("an array with a single element is sorted") {
    assert(isSorted(Array(1), ord))
  }

  test("it should check whether an array is sorted") {
    assert(isSorted(Array(1, 6, 13, 55, 67, 221), ord))
    assert(!isSorted(Array(1, 6, 131, 55, 67, 221), ord))
  }

  test("it should check whether a list is sorted") {
    val sorted = List(1, 23, 67, 890, 1294, 1348, 1500)
    val unsorted = List(14, 42, 223, 32, 12, 455)
    assert(isSorted(sorted))
    assert(!isSorted(unsorted))
  }

  val ord: (Int, Int) => Boolean = (x, y) => x <= y
}
