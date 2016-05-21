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
import Es3_14._

class Es3_14Suite extends FunSuite {
  test("it should append two lists") {
    val a = List(1, 2, 3)
    val b = List(4, 5, 6)
    assert(append(a, b) == List(1, 2, 3, 4, 5, 6))
    assert(append(Nil, b) == b)
    assert(append(a, Nil) == a)
    assert(append(Nil, Nil) == Nil)
  }

  test("it should append two lists (left variant)") {
    val a = List(1, 2, 3)
    val b = List(4, 5, 6)
    assert(appendL(a, b) == appendR(a, b))
  }
}
