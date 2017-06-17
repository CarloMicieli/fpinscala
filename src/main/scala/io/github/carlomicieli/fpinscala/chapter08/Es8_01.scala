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

package io.github.carlomicieli.fpinscala.chapter08

/** EXERCISE 8.1] To get used to thinking about testing in this way, come up with properties
  *              that specify the implementation of a `sum: List[Int] => Int` function.
  */
trait Es8_01 {

  def sum(xs: List[Int]): Int = xs.foldLeft(0)(_ + _)

  def replicate(x: Int, s: Int): List[Int] = {
    def loop(n: Int, out: List[Int]): List[Int] = {
      if (n == 0) {
        out
      } else {
        loop(n - 1, x :: out)
      }
    }

    loop(s, List())
  }

}
