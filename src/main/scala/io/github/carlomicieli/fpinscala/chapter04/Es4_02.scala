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

package io.github.carlomicieli.fpinscala.chapter04

/** EXERCISE 4.2] Implement the `variance` function in terms of `flatMap`. If the mean of a sequence is `m`,
  *             the variance is the mean of `math.pow(x - m, 2)` for each element x in the sequence.
  *             See the definition of variance on Wikipedia (http://mng.bz/0Qsr).
  */
trait Es4_02 {
  def variance(xs: Seq[Double]): Option[Double] = {
    val f: (Double, Double) => Double = (m, x) => math.pow(x - m, 2)
    mean(xs).flatMap(m => {
      mean(xs.map(f(m, _)))
    })
  }

  def mean(xs: Seq[Double]): Option[Double] = {
    import Option._
    if (xs.isEmpty) {
      none[Double]
    } else {
      some(xs.sum / xs.length.toDouble)
    }
  }
}
