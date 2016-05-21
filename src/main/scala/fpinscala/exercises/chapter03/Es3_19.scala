// Copyright (C) 2016 the original author or authors.
// See the LICENCE.txt file distributed with this work for additional
// information regarding copyright ownership.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package fpinscala.exercises.chapter03

/**
  * EXERCISE 3.19] Write a function `filter` that removes elements from a list unless they satisfy
  *                a given predicate. Use it to remove all odd numbers from a `List[Int]`.
  */
object Es3_19 {
  def filter[A](as: List[A])(p: A => Boolean): List[A] =
    as.foldLeft(List.empty[A])((xs, x) => if (p(x)) x :: xs else xs).reverse

  def removeOdd(list: List[Int]): List[Int] = {
    val isEven: Int => Boolean = x => x % 2 == 0
    filter(list)(isEven)
  }
}
