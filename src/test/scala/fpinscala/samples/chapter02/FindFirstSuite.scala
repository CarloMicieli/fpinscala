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
package fpinscala.samples.chapter02

import org.scalatest.FunSuite

class FindFirstSuite extends FunSuite {
  test("it should return None when no value makes the predicate true") {
    val a = Array(2, 4, 6, 8, 10)
    assert(FindFirst(a)(_ % 2 != 0) == None)
  }

  test("it should return the first index that makes the predicate true") {
    val a = Array(2, 4, 6, 8, 10)
    assert(FindFirst(a)(_ >= 8) == Some(3))
  }

  test("it should always return None when the array is empty") {
    val empty = new Array[Int](0)
    assert(FindFirst(empty)(_ > 0) == None)
  }
}
