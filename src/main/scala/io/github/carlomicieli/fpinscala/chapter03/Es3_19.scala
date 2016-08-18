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
  * EXERCISE 3.19] Write a function `filter` that removes elements from a list unless they satisfy
  *                a given predicate. Use it to remove all odd numbers from a `List[Int]`.
  */
trait Es3_19 {
  def filter[A](as: List[A])(p: A => Boolean): List[A] = {
    val zero = List.empty[A]
    val step = (x: A, xs: List[A]) => {
      if (p(x)) Cons(x, xs) else xs
    }
    as.foldRight(zero)(step)
  }

  def removeOdd(list: List[Int]): List[Int] = {
    val isEven: Int => Boolean = x => x % 2 == 0
    filter(list)(isEven)
  }
}
