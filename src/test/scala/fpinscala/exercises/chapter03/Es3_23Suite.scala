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
package fpinscala.exercises.chapter03

import org.scalatest.FunSuite
import Es3_23._

class Es3_23Suite extends FunSuite {
  test("it should apply a function to corresponding elements in two lists") {
    assert(zipWith(List(1, 2, 3), List(4, 5, 6))(_ + _) == List(5, 7, 9))
    assert(zipWith(List("1", "2", "3"), List("4", "5", "6"))(_ + _) == List("14", "25", "36"))
  }

  test("it should produce a list with the same number of elements as the shortest list") {
    assert(zipWith(List(1, 2), List(4, 5, 6))(_ + _) == List(5, 7))
    assert(zipWith(List(1, 2, 3), List(4, 5))(_ + _) == List(5, 7))
    assert(zipWith(List(1, 2), Nil)(_ + _) == Nil)
    assert(zipWith(Nil, List(4, 5, 6))(_ + _) == Nil)
  }
}
