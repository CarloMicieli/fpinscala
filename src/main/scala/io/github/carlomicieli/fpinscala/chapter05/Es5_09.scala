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

package io.github.carlomicieli.fpinscala.chapter05

/** EXERCISE 5.9] Write a function that generates an infinite stream of integers, starting from n, then
  *              n + 1, n + 2, and so on.
  */
trait Es5_09 {
  def from(n: Int): Stream[Int] = {
    Stream.cons(n, from(n + 1))
  }
}