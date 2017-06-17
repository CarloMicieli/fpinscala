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

/** EXERCISE 6.2] Write a function to generate a `Double` between 0 and 1, not including 1. Note: You can
  *              use `Int.MaxValue` to obtain the maximum positive integer value, and you can use
  *              `x.toDouble` to convert an `x: Int` to a `Double`.
  */
trait Es6_02 {
  def double(rng: RNG): (Double, RNG) = {
    rng.nextDouble
  }
}
