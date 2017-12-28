/*
 * Copyright 2017 Carlo Micieli
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

/** EXERCISE 6.7] Hard: If you can combine two `RNG` transitions, you should be able to combine a whole
  *             list of them. Implement sequence for combining a `List` of transitions into a single
  *             transition. Use it to reimplement the `ints` function you wrote before. For the latter,
  *             you can use the standard library function `List.fill(n)(x)` to make a list with `x`
  *             repeated `n` times.
  */
trait Es6_07 {
  def sequence[A](fs: List[Rand[A]]): Rand[List[A]] =
    fs.foldRight(unit(List.empty[A]))(step)

  private def step[A](r: Rand[A], rs: Rand[List[A]]): Rand[List[A]] =
    map2(r, rs)((x, xs) => x :: xs)
}
