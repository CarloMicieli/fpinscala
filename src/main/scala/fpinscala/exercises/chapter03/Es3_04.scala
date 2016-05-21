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
  * EXERCISE 3.4] Generalize `tail` to the function `drop`, which removes the first n elements from
  *               a list. Note that this function takes time proportional only to the number of
  *               elements being dropped — we don't need to make a copy of the entire `List`.
  */
object Es3_04 {
  @annotation.tailrec
  def drop[A](l: List[A], n: Int): List[A] = (n, l) match {
    case (i, _) if i <= 0 => l
    case (_, _ Cons xs)   => drop(xs, n - 1)
    case (_, Nil)         => Nil
  }
}
