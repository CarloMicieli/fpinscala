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
  * EXERCISE 3.15] Hard: Write a function that concatenates a list of lists into a single list.
  *                Its runtime should be linear in the total length of all lists. Try to use
  *                functions we have already defined.
  */
trait Es3_15 {
  def concat[A](list: List[List[A]]): List[A] = {
    list.foldRight(List.empty[A])((xss, xs) => xss append xs)
  }

  /*

    concat(List(List(1, 2), List(3), List(4, 5)) evaluate to
    (List(1, 2) ++ (List(3) ++ (Nil ++ List(4,5))))

    Nil ++ List(4,5)            => 0 steps
    List(3) ++ List(4,5)        => 1 step
    List(1, 2) ++ List(3, 4, 5) => 2 steps
                                   --------
                                   3 steps ~ O(n)

   */
}
