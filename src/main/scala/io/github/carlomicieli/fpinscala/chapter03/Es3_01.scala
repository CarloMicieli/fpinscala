/*
 * Copyright 2017 CarloMicieli
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

/** EXERCISE 3.1] What will be the result of the following match expression?
  * @example {{{
  * val x = List(1,2,3,4,5) match {
  *  case Cons(x, Cons(2, Cons(4, _))) => x
  *  case Nil => 42
  *  case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y
  *  case Cons(h, t) => h + sum(t)
  *  case _ => 101
  * }
  * }}}
  */
trait Es3_01 {
  def apply(xs: List[Int]): Any = {
    xs match {
      case Cons(x, Cons(2, Cons(4, _)))          => x
      case Nil                                   => 42
      case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y
      case Cons(h, t)                            => h + sum(t)
      case _                                     => 101
    }
  }

  private def sum(xs: List[Int]): Int = xs match {
    case Nil              => 0
    case Cons(head, tail) => head + sum(tail)
  }
}
