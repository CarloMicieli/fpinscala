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

package io.github.carlomicieli.fpinscala.chapter04

/** EXERCISE 4.4] Write a function sequence that combines a list of `Option`s into one
  *              `Option` containing a list of all the `Some` values in the original list.
  *              If the original list contains `None` even once, the result of the function
  *              should be `None`; otherwise the result should be `Some` with a list of
  *              all the values.
  */
trait Es4_04 extends Es4_03 {
  def sequence[A](a: List[Option[A]]): Option[List[A]] = {
    val step = (x: Option[A], xs: Option[List[A]]) => map2(x, xs)(_ :: _)
    a.foldRight(Option.some(List.empty[A]))(step)
  }
}
