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

/** EXERCISE 5.11] Write a more general stream-building function called `unfold`. It takes an initial state,
  *               and a function for producing both the next state and the next value in the generated
  *               stream.
  */
trait Es5_11 {
  def unfold[A, S](initial: S)(f: S => Option[(A, S)]): Stream[A] = {
    f(initial) match {
      case None         => Stream.empty[A]
      case Some((a, s)) => Stream.cons(a, unfold(s)(f))
    }
  }
}
