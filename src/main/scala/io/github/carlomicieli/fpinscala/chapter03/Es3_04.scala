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

package io.github.carlomicieli.fpinscala.chapter03

/**
  * EXERCISE 3.4] Generalize `tail` to the function `drop`, which removes the first n elements from
  *               a list. Note that this function takes time proportional only to the number of
  *               elements being dropped — we don't need to make a copy of the entire `List`.
  */
trait Es3_04 {
  @annotation.tailrec
  final def drop[A](l: List[A], n: Int): List[A] = {
    (l, n) match {
      case (_, i) if i <= 0 => l
      case (Cons(x, xs), i) => drop(xs, i - 1)
      case (Nil, _)         => Nil
    }
  }
}
