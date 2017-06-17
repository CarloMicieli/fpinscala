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

package io.github.carlomicieli.fpinscala.chapter03

/** EXERCISE 3.20] Write a function `flatMap` that works like `map` except that the function
  *               given will return a list instead of a single result, and that list should
  *               be inserted into the final resulting list.
  */
trait Es3_20 {
  def flatMap[A, B](as: List[A])(f: A => List[B]): List[B] = {
    as.foldRight(List.empty[B])((x, xs) => f(x) append xs)
  }
}
