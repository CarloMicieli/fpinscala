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
import Es2_5._

class Es2_5Suite extends FunSuite {
  test("it should compose functions") {
    val doubleMe = (x: Int) => x * 2
    val toString = (x: Int) => s"Number($x)"

    val f = compose(toString, doubleMe)
    val g = andThen(doubleMe, toString)
    assert(f(21) == "Number(42)")
    assert(g(21) == "Number(42)")
  }
}
