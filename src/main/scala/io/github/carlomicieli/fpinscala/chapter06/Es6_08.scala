/*
 * Copyright 2017 CarloMicieli
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

import RNG._

/** EXERCISE 6.8] Implement `flatMap`, and then use it to implement `nonNegativeLessThan`.
  */
trait Es6_08 {
  def nonNegativeLessThan(n: Int): Rand[Int] = flatMap(nonNegativeInt) {
    i =>
      {
        val mod = i % n
        if (i + (n - 1) - mod >= 0)
          unit(mod)
        else
          nonNegativeLessThan(n)
      }
  }

  private def nonNegativeInt(rng: RNG): (Int, RNG) = {
    val (n1, rng2) = rng.nextInt
    (abs2(n1), rng2)
  }

  private def abs2(n: Int): Int = n match {
    case Int.MinValue => 0
    case _ if n >= 0  => n
    case _ if n < 0   => math.abs(n)
  }
}
