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

/** EXERCISE 3.12] Write a function that returns the reverse of a list (given `List(1,2,3)` it
  *               returns `List(3,2,1)`). See if you can write it using a `fold`.
  */
trait Es3_12 {
  def reverse[A](as: List[A]): List[A] = {
    as.foldLeft(List.empty[A])((xs, x) => Cons(x, xs))
  }
}
