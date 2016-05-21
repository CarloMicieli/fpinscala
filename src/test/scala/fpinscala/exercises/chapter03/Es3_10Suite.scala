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
import Es3_10._

class Es3_10Suite extends FunSuite {
  test("foldRight is not stack-safe: it should blow the stack with long lists") {
    val thrown = intercept[StackOverflowError] {
      blowTheStack()
    }
  }

  test("foldLeft is tail call optimized: it won't blow the stack") {
    assert(stackSafeCount() == 500000500000L)
  }
}
