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
import Es5_05._

class Es5_05Suite extends FunSuite {
  test("it should take elements while they match predicate") {
    val s = Stream.range(1, 100)
    assert(takeWhile(s)(_ < 10).toList == (1 until 10).toList)
  }

  test("it should work for infinite streams") {
    val s = Stream.from(42)
    assert(takeWhile(s)(_ < 50).toList == (42 until 50).toList)
  }
}
