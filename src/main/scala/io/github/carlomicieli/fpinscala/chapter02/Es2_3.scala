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

package io.github.carlomicieli.fpinscala.chapter02

/** EXERCISE 2.3] Let’s look at another example, currying, which converts a
  *             function `f` of two arguments into a function of one argument
  *             that partially applies `f`. Here again there’s only one
  *             implementation that compiles. Write this implementation.
  */
trait Es2_3 {
  def curry[A, B, C](f: (A, B) => C): A => (B => C) = {
    a => partial(a, f)
  }

  private def partial[A, B, C](a: A, f: (A, B) => C): B => C =
    b => f(a, b)
}
