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
  * EXERCISE 3.20] Write a function `flatMap` that works like `map` except that the function
  *                given will return a list instead of a single result, and that list should
  *                be inserted into the final resulting list.
  */
object Es3_20 {
  def flatMap[A, B](as: List[A])(f: A => List[B]): List[B] =
    as.foldRight(List.empty[B])((x, xs) => f(x) ++ xs)

  def flatMapV2[A, B](as: List[A])(f: A => List[B]): List[B] =
    as.foldLeft(List.empty[B])((xs, x) => xs ++ f(x))

  def flatMapV3[A, B](as: List[A])(f: A => List[B]): List[B] = as.map(f).flatten
}
