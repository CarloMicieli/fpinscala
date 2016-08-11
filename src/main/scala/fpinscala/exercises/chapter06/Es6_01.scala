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

/**
  * EXERCISE 6.1] Write a function that uses `RNG.nextInt` to generate a random integer between 0 and
  *               `Int.maxValue` (inclusive). Make sure to handle the corner case when `nextInt` returns
  *               `Int.MinValue`, which doesn't have a non-negative counterpart.
  */
object Es6_01 {
  def nonNegativeInt(rng: RNG): (Int, RNG) = {
    val (n1, rng2) = rng.nextInt
    (abs2(n1), rng2)
  }

  private def abs2(n: Int): Int = n match {
    case Int.MinValue => 0
    case _ if n >= 0  => n
    case _ if n < 0   => math.abs(n)
  }
}
