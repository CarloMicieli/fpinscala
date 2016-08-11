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
import Es6_02._

class Es6_02Suite extends FunSuite {
  test("it should produce double number between 0 and 1") {
    val (d, _) = double(SimpleRNG(42))
    assert(d >= 0 && d < 1)
    assert(d == 0.007524831689672932)
  }
}
