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

import io.github.carlomicieli.fpinscala._

/** EXERCISE 3.2] Implement the function `tail` for removing the first element of a `List`. Note that the
  *             function takes constant time. What are different choices you could make in your
  *             implementation if the `List` is `Nil`?
  */
trait Es3_02 {
  def tail[A](xs: List[A]): List[A] = {
    xs match {
      case Cons(_, ys) => ys
      case Nil         => error("List.tail: list is empty")
    }
  }

  def tailOption[A](xs: List[A]): Option[List[A]] = {
    xs match {
      case Cons(_, ys) => Some(ys)
      case Nil         => None
    }
  }
}
