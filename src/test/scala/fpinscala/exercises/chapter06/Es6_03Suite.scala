/*
 * Copyright 2016 Carlo Micieli
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package fpinscala.exercises.chapter06

import org.scalatest.FunSuite
import Es6_03._

class Es6_03Suite extends FunSuite {
  test("it should produce an integer and a double pair") {
    val rng = SimpleRNG(42)
    val ((i, d), _) = intDouble(rng)
    assert(i == 16159453)
    assert(d == 0.5967354856416283)
  }

  test("it should produce a double and an integer pair") {
    val rng = SimpleRNG(42)
    val ((d, i), _) = doubleInt(rng)
    assert(i == -1281479697)
    assert(d == 0.007524831689672932)
  }

  test("it should produce three double numbers") {
    val rng = SimpleRNG(42)
    val ((d1, d2, d3), _) = double3(rng)
    assert(d1 == 0.007524831689672932)
    assert(d2 == 0.5967354856416283)
    assert(d3 == 0.15846728447753344)
  }
}
