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
import Es3_28._

class Es3_28Suite extends FunSuite {
  test("it should map a tree") {
    val f: Int => Int = x => x * 2
    val tree = Branch(Branch(Leaf(1), Leaf(2)), Leaf(3))

    assert(map(Leaf(21))(f) == Leaf(42))
    assert(map(tree)(f) == Branch(Branch(Leaf(2), Leaf(4)), Leaf(6)))
  }
}
