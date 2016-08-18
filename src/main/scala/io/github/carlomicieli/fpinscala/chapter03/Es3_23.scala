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
  * EXERCISE 3.23] Generalize the function you just wrote so that it's not specific to integers
  *                or addition. Name your generalized function `zipWith`.
  */
trait Es3_23 {
  def zipWith[A, B](as: List[A], bs: List[A])(f: (A, A) => B): List[B] = {
    (as, bs) match {
      case (Cons(x, xs), Cons(y, ys)) => Cons(f(x, y), zipWith(xs, ys)(f))
      case _                          => Nil
    }
  }

  def zip[A, B](as: List[A], bs: List[B]): List[(A, B)] = {
    @annotation.tailrec
    def loop(xs: List[A], ys: List[B], acc: List[(A, B)]): List[(A, B)] = {
      (xs, ys) match {
        case (Nil, _)                     => acc
        case (_, Nil)                     => acc
        case (Cons(h1, t1), Cons(h2, t2)) => loop(t1, t2, Cons((h1, h2), acc))
      }
    }

    loop(as, bs, List.empty[(A, B)]).reverse
  }
}
