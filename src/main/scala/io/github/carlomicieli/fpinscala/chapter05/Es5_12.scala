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

/** EXERCISE 5.12] Write `fibs`, `from`, `constant`, and `ones` in terms of `unfold`.
  */
trait Es5_12 extends Es5_11 {
  def fibs: Stream[Int] = {
    unfold((0, 1))(s => {
      val (n1, n2) = s
      Some((n1, (n2, n1 + n2)))
    })
  }

  def from(n: Int): Stream[Int] = {
    unfold(n)(s => Some((s, s + 1)))
  }

  def constant[A](n: A): Stream[A] = {
    unfold(n)(same)
  }

  def ones: Stream[Int] = {
    constant(1)
  }

  private def same[A](default: A): Option[(A, A)] = {
    Some((default, default))
  }
}
