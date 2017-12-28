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

/** EXERCISE 3.22] Write a function that accepts two lists and constructs a new list by adding
  *              corresponding elements. For example, `List(1, 2, 3)` and `List(4, 5, 6)`
  *              become `List(5, 7, 9)`.
  */
trait Es3_22 {
  def add(as: List[Int], bs: List[Int]): List[Int] = (as, bs) match {
    case (Cons(x, xs), Cons(y, ys)) => Cons(x + y, add(xs, ys))
    case _                          => Nil
  }
}
