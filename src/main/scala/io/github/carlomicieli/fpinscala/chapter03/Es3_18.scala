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
package io.github.carlomicieli.fpinscala.chapter03

/**
  * EXERCISE 3.18] Write a function `map` that generalizes modifying each element in a list while
  *                maintaining the structure of the `list`.
  */
trait Es3_18 {
  def map[A, B](as: List[A])(f: A => B): List[B] = {
    as.foldRight(List.empty[B])((x, xs) => Cons(f(x), xs))
  }
}