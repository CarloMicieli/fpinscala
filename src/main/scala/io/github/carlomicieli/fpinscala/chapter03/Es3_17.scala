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

/** EXERCISE 3.17] Write a function that turns each value in a `List[Double]` into a `String`.
  *               You can use the expression `d.toString` to convert some `d: Double`
  *               to a `String`.
  */
trait Es3_17 {
  def convert(as: List[Double]): List[String] = {
    as.foldRight(List.empty[String])((x, xs) => Cons(x.toString, xs))
  }
}
