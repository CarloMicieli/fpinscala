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
import Es6_09._
import RNG.int

class Es6_09Suite extends FunSuite {
  test("it should implement map in terms of flatMap") {
    val rng = SimpleRNG(42)
    val (n, _) = int(rng)
    val (n2, _) = map(int)(_ * 2)(rng)

    assert(n2 == n * 2)
  }

  test("it should implement map2 in terms of flatMap") {
    val rng = SimpleRNG(42)
    val (n1, rng2) = int(rng)
    val (n2, _) = int(rng2)

    val (n3, _) = map2(int, int)(_ - _)(rng)
    assert(n1 - n2 == n3)
  }
}
