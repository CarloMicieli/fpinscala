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

package io.github.carlomicieli.fpinscala.chapter03

/** EXERCISE 3.14] Implement `append` in terms of either `foldLeft` or `foldRight`.
  */
trait Es3_14 {
  def append[A](as: List[A], bs: List[A]): List[A] = appendL(as, bs)

  def appendR[A](as: List[A], bs: List[A]): List[A] = {
    as.foldRight(bs)(Cons(_, _))
  }

  def appendL[A](as: List[A], bs: List[A]): List[A] = {
    as.reverse.foldLeft(bs)((xs, x) => Cons(x, xs))
  }
}
