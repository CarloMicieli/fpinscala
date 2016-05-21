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
package fpinscala.samples.chapter05

import org.scalatest.FunSuite
import LazyEval._

class LazyEvalSuite extends FunSuite {
  test("it should evaluate everything strictly") {
    var i = 0

    val res = cond1(false, { i = i + 1; "A" }, { i = i + 10; "B" })
    assert(res == "B")
    assert(i == 11)
  }

  test("it should evaluate arguments like functions") {
    var i = 0

    val res = cond2(false, () => { i = i + 1; "A" }, () => { i = i + 10; "B" })
    assert(res == "B")
    assert(i == 10)
  }

  test("it should evaluate arguments by name") {
    var i = 0

    val res = cond3(false, { i = i + 1; "A" }, { i = i + 10; "B" })
    assert(res == "B")
    assert(i == 10)
  }

  test("it should evaluate argument twice") {
    var n = 0
    val x = maybeTwice(true, { n = n + 1; 10 })

    assert(x == 20)
    assert(n == 2)
  }

  test("it should evaluate the arguments and memoize their values") {
    var n = 0
    val x = maybeTwice2(true, { n = n + 1; 10 })

    assert(x == 20)
    assert(n == 1)
  }
}
