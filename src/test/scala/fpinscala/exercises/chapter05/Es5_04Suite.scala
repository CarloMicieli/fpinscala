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

package fpinscala.exercises.chapter05

import org.scalatest.FunSuite

class Es5_04Suite extends FunSuite {
  test("it should return true when all elements match the predicate") {
    val s = Stream.range(1, 100)
    assert(s.forAll(_ < 1000))
  }

  test("it should return false as soon as it find a non matching element") {
    val s = Stream.range(1, 100)
    assert(!s.forAll(_ > 1000))
  }

  test("it should manage infinite stream if a non matching element exists") {
    val s = Stream.from(42)
    assert(!s.forAll(_ == 0))
  }
}
