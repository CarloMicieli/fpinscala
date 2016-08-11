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
import Es6_07._
import RNG._

class Es6_07Suite extends FunSuite {
  test("it should combine a sequence of random generators") {
    val seq: List[Rand[Int]] = List.fill(10)(int)
    val (xs, _) = sequence(seq)(SimpleRNG(42))
    assert(xs == List(16159453, -1281479697, -340305902, -2015756020, 1770001318, -1934589059, 1015914512, -1163632441, -94901159, 1837487774))
  }
}
