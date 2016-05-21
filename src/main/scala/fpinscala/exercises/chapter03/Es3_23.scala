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
  * EXERCISE 3.23] Generalize the function you just wrote so that it's not specific to integers
  *                or addition. Name your generalized function `zipWith`.
  */
object Es3_23 {
  def zipWith[A, B](as: List[A], bs: List[A])(f: (A, A) => B): List[B] = (as, bs) match {
    case (x Cons xs, y Cons ys) => f(x, y) :: zipWith(xs, ys)(f)
    case _                      => Nil
  }
}
