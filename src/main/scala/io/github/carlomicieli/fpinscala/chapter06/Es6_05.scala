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

import RNG._

/**
  * EXERCISE 6.5] Use `map` to reimplement `double` in a more elegant way.
  */
trait Es6_05 {
  def double(rng: RNG): (Double, RNG) =
    map(_.nextInt)(toDouble)(rng)

  private def toDouble(n: Int): Double = n match {
    case Int.MaxValue | Int.MinValue => 0.0
    case i                           => math.abs(i) / Int.MaxValue.toDouble
  }
}
