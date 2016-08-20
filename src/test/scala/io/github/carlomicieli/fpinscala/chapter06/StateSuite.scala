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

package io.github.carlomicieli.fpinscala.chapter06

import io.github.carlomicieli.fpinscala.chapter06.State._
import org.scalatest.FunSuite

class StateSuite extends FunSuite {
  test("it should create the unit state") {
    val (a, _) = unit(42)("one")
    assert(a == 42)

    val (b, _) = unit(42)("two")
    assert(b == 42)
  }

  test("it should map a state value with a function") {
    val state: State[String, Int] = unit(42)
    val (a, _) = map(state)(_ * 2)("")
    assert(a == 84)
  }

  test("it should map two states") {
    val s1: State[String, Int] = unit(21)
    val s2: State[String, Int] = unit(21)

    val (a, _) = map2(s1, s2)(_ + _)("run")
    assert(a == 42)
  }

  test("it should produce a sequence of state") {
    val ls: List[State[String, Int]] = List.fill(5)(unit(1))
    val (out, _) = sequence(ls)("")
    assert(out == List(1, 1, 1, 1, 1))
  }
}
