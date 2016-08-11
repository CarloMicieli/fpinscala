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
import Es5_10._

class Es5_10Suite extends FunSuite {
  test("it should produce a stream with the fibonacci numbers") {
    assert(fibs.take(10).toList == List(0, 1, 1, 2, 3, 5, 8, 13, 21, 34))
  }
}
