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

/** EXERCISE 3.11] Write `sum`, `product`, and a function to compute the length of a
  *               list using `foldLeft`.
  */
trait Es3_11 {
  def sum[A](as: List[A])(implicit num: Numeric[A]): A = {
    as.foldLeft(num.zero)(sum(_, _))
  }

  def product[A](as: List[A])(implicit num: Numeric[A]): A = {
    as.foldLeft(num.one)(times(_, _))
  }

  def length[A](as: List[A]): Int = {
    as.foldLeft(0)((n, _) => n + 1)
  }

  private def times[A: Numeric](a: A, b: A): A = {
    val num = implicitly[Numeric[A]]
    num.times(a, b)
  }

  private def sum[A: Numeric](a: A, b: A): A = {
    val num = implicitly[Numeric[A]]
    num.plus(a, b)
  }
}
