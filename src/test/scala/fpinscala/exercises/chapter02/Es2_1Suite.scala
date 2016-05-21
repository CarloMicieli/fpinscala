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
import Es2_1._

class Es2_1Suite extends FunSuite {

  test("The 7th fibonacci number is 21") {
    assert(fib(7) == 21)
    assert(fibIter(7) == 21)
  }

  test("It should be undefined for negative numbers") {
    val thrown = intercept[IllegalArgumentException] {
      fibIter(-1)
    }
  }
}
