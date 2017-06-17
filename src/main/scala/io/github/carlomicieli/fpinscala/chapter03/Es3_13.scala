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

/** EXERCISE 3.13] Can you write `foldLeft` in terms of `foldRight`? How about the other way
  *               around? Implementing `foldRight` via `foldLeft` is useful because it lets us
  *               implement `foldRight` tail-recursively, which means it works even for large
  *               lists without overflowing the stack.
  */
trait Es3_13 {
  def foldRight[A, B](as: List[A], z: B)(f: (A, B) => B): B = {
    as.foldLeft(identity[B] _)((g, a) => g compose ((b: B) => f(a, b)))(z)
  }

  def foldLeft[A, B](as: List[A], z: B)(f: (B, A) => B): B = {
    as.foldRight(identity[B] _)((a, g) => g compose ((b: B) => f(b, a)))(z)
  }
}
