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
import Es3_19._

class Es3_19Suite extends FunSuite {
  test("it should filter out elements that don't match the predicate") {
    assert(filter(List(1, 2, 3, 4, 5))(_ % 2 == 0) == List(2, 4))
    assert(filter(List.empty[Int])(_ % 2 == 0) == Nil)
  }

  test("it should remove of the odd numbers from a list") {
    val l = List(1, 2, 3, 4, 5)
    assert(removeOdd(l) == List(2, 4))
  }
}
