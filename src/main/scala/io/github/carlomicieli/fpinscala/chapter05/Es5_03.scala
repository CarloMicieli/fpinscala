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

/** EXERCISE 5.3] Write the function `takeWhile` for returning all starting elements of a `Stream` that
  *             match the given predicate.
  */
trait Es5_03 {
  def takeWhile[A](s: Stream[A])(p: A => Boolean): Stream[A] = {
    s match {
      case Cons(h, t) if p(h()) => Stream.cons(h(), takeWhile(t())(p))
      case _                    => Stream.empty[A]
    }
  }

  def dropWhile[A](s: Stream[A])(p: A => Boolean): Stream[A] = {
    s match {
      case Cons(h, t) if p(h()) => dropWhile(t())(p)
      case _                    => s
    }
  }
}
