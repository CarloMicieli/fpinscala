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
import Es5_12._

class Es5_12Suite extends FunSuite {
  test("it should implement ones in terms of unfold") {
    assert(ones.take(100).toList.forall(_ == 1))
  }

  test("it should implement constant in terms of unfold") {
    assert(constant("42").take(100).toList.forall(_ == "42"))
  }

  test("it should implement from in terms of unfold") {
    assert(from(1).take(10).toList == (1 to 10).toList)
  }

  test("it should implement fibs in terms of unfold") {
    assert(fibs.take(10).toList == List(0, 1, 1, 2, 3, 5, 8, 13, 21, 34))
  }
}
