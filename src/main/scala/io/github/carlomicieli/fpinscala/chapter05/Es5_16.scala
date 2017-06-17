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

/** EXERCISE 5.16] Hard: Generalize `tails` to the function `scanRight`, which is like a `foldRight` that
  *               returns a stream of the intermediate results. For example:
  *
  * @{{{
  * scala> Stream(1, 2, 3).scanRight(0)(_ + _).toList
  * res0: List[Int] = List(6, 5, 3, 0)
  * }}}
  *
  *               This example should be equivalent to the expression `List(1 + 2 + 3 + 0, 2 + 3 + 0, 3 + 0, 0)`.
  *               Your function should reuse intermediate results so that traversing a `Stream` with `n`
  *               elements always takes time linear in n. Can it be implemented using unfold? How, or
  *               why not? Could it be implemented using another function we’ve written?
  */
trait Es5_16 {
  def scanRight[A, B](stream: Stream[A])(z: => B)(f: (A, => B) => B): Stream[B] = {
    (z, stream) match {
      case (b, Empty) => Stream(b)
      case (b, Cons(h, t)) =>
        val yss = scanRight(t())(z)(f)
        val ys = yss.headOption.get
        Stream.cons(f(h(), ys), yss)
    }
  }
}
