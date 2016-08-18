/*
 * Copyright 2016 Carlo Micieli
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

/**
  * EXERCISE 2.4] Implement `unCurry`, which reverses the transformation of `curry`.
  *               Note that since `=>` associates to the right, `A => (B => C)` can
  *               be written as `A => B => C`.
  */
trait Es2_4 {
  def unCurry[A, B, C](f: A => (B => C)): (A, B) => C = {
    (a, b) => f(a)(b)
  }
}
