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

/** EXERCISE 3.16] Write a function that transforms a list of integers by adding 1 to each element.
  *              (Reminder: this should be a pure function that returns a new `List`!)
  */
trait Es3_16 {
  def addOne[A](as: List[A])(implicit num: Numeric[A]): List[A] = {
    as.foldRight(List.empty[A])((x, acc) => Cons(num.plus(x, num.one), acc))
  }
}
