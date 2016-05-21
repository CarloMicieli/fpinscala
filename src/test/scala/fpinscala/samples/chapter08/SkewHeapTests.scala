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
package fpinscala.samples.chapter08

import org.scalatest.{ Matchers, FunSuite }

class SkewHeapTests extends FunSuite with Matchers {
  test("it should check whether heaps are valid") {
    val h1 = Fork(1, Fork(99, Empty, Empty), Empty)
    val h2 = Fork(99, Fork(1, Empty, Empty), Empty)

    h1.isValid should be(true)
    h2.isValid should be(false)
  }

  test("it should check whether heaps are balanced") {
    val h1 = Fork(1, Fork(2, Empty, Empty), Empty)
    val h2 = Fork(1, Fork(2, Empty, Empty), Fork(3, Empty, Empty))
    val h3 = Fork(1, Fork(2, Empty, Fork(3, Empty, Empty)), Empty)

    h1.isBalanced should be(true)
    h2.isBalanced should be(true)
    h3.isBalanced should be(false)
  }
}