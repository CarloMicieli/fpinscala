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

package io.github.carlomicieli.fpinscala.chapter05

/** EXERCISE 5.15] Implement `tails` using `unfold`. For a given `Stream`, `tails` returns the `Stream`
  *              of suffixes of the input sequence, starting with the original `Stream`. For example, given
  *              `Stream(1,2,3)`, it would return `Stream(Stream(1,2,3), Stream(2,3), Stream(3), Stream())`.
  */
trait Es5_15 extends Es5_11 {
  def tails[A](stream: Stream[A]): Stream[Stream[A]] =
    unfold((stream, false)) {
      case (_, true)           => None
      case (Empty, _)          => Some((Empty, (Empty, true)))
      case (s @ Cons(_, t), _) => Some((s, (t(), false)))
    }
}
