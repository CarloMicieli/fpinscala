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
package fpinscala.exercises.chapter04

import org.scalatest.{ Matchers, FunSuite }
import Es4_03._

class Es4_03Suite extends FunSuite with Matchers {
  test("it should map over two Option values") {
    val some1 = Some(40)
    val some2 = Some(2)
    val none = None

    val f: (Int, Int) => Int = _ + _

    map2(some1, some2)(f) should be(Some(42))
    map2(some1, none)(f) should be(None)
    map2(none, some2)(f) should be(None)
    map2V2(some1, some2)(f) should be(Some(42))
    map2V2(none, some2)(f) should be(None)
  }
}
