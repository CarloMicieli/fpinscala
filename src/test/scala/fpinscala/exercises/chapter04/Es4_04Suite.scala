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
import Es4_04._

class Es4_04Suite extends FunSuite with Matchers {
  test("it should combine a sequence of Some values") {
    val l = List(Some(1), Some(2), Some(3), Some(4))
    sequence(l) should be(Some(List(1, 2, 3, 4)))
    sequenceV2(l) should be(Some(List(1, 2, 3, 4)))
  }

  test("it should combine a sequence of Option values") {
    val l = List(Some(1), Some(2), None, Some(4))
    sequence(l) should be(None)
    sequenceV2(l) should be(None)
  }
}
