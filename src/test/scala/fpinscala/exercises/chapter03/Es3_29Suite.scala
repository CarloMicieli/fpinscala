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
import Es3_29._

class Es3_29Suite extends FunSuite {
  test("it should implement depth with fold") {
    val t1 = Leaf(42)
    val t2 = Branch(Branch(Leaf(1), Leaf(2)), Leaf(3))
    assert(depth(t1) == 0)
    assert(depth(t2) == 2)
  }

  test("it should implement maximum with fold") {
    val t1 = Leaf(42)
    val t2 = Branch(Branch(Leaf(1), Leaf(2)), Leaf(3))
    assert(maximum(t1) == 42)
    assert(maximum(t2) == 3)
  }

  test("it should implement size with fold") {
    val t1 = Leaf(42)
    val t2 = Branch(Branch(Leaf(1), Leaf(2)), Leaf(3))
    assert(size(t1) == 1)
    assert(size(t2) == 3)
  }

  test("it should implement map with fold") {
    val t1 = Branch(Branch(Leaf(1), Leaf(2)), Leaf(3))
    assert(map(t1, (x: Int) => x * 2) == Branch(Branch(Leaf(2), Leaf(4)), Leaf(6)))
  }

}
