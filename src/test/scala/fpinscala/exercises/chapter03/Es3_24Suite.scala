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
import Es3_24._

class Es3_24Suite extends FunSuite {
  test("it should check whether a list is a subsequence") {
    val list = List(1, 2, 3, 4)
    val sub1 = List(1, 4)
    val sub2 = List(3, 4, 5)
    val sub3 = List(3, 4)
    assert(!hasSubsequence(list, sub1))
    assert(!hasSubsequence(list, sub2))
    assert(hasSubsequence(list, sub3))
    assert(hasSubsequence(list, List()))
  }
}
