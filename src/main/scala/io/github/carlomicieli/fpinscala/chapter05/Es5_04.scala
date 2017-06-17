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

/** EXERCISE 5.4] Implement `forAll`, which checks that all elements in the `Stream` match a given predicate.
  *              Your implementation should terminate the traversal as soon as it encounters a
  *              non matching value.
  */
trait Es5_04 {
  def forAll[A](s: Stream[A])(p: A => Boolean): Boolean = {
    s.foldRight(true)((a, b) => p(a) && b)
  }
}
