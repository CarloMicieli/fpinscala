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
package fpinscala.exercises.chapter06

import org.scalatest.FunSuite
import Es6_04._

class Es6_04Suite extends FunSuite {
  test("it should produce a list of random numbers") {
    val rng = SimpleRNG(42)
    val (num, _) = ints(5)(rng)
    assert(num == List(1770001318, -2015756020, -340305902, -1281479697, 16159453))
  }
}
