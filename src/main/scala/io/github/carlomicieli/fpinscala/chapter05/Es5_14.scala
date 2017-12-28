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

/** EXERCISE 5.14] Hard: Implement `startsWith` using functions you've written. It should check if one
  *              `Stream` is a prefix of another. For instance, `Stream(1, 2, 3) startsWith Stream(1, 2)`
  *              would be true.
  */
trait Es5_14 {
  def startsWith[A](as: Stream[A], bs: Stream[A]): Boolean = {
    !zip(as, bs).exists { case (x, y) => x != y }
  }

  private def zip[A, B](s1: Stream[A], that: Stream[B]): Stream[(A, B)] = (s1, that) match {
    case (Empty, _)                   => Empty
    case (_, Empty)                   => Empty
    case (Cons(ah, at), Cons(bh, bt)) => Stream.cons((ah(), bh()), zip(at(), bt()))
  }
}