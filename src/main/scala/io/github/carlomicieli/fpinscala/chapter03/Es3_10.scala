/*
 * Copyright 2017 Carlo Micieli
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

/** EXERCISE 3.10] Our implementation of `foldRight` is not tail-recursive and will result in a StackOverflowError
  *              for large lists (we say it’s not stack-safe). Convince yourself that this is the
  *              case, and then write another general list-recursion function, `foldLeft`, that is
  *              tail-recursive, using the techniques we discussed in the previous chapter.
  */
trait Es3_10 {
  private val veryLongList = initList

  def blowTheStack(): Long = {
    foldRight(veryLongList, 0L)(_ + _)
  }

  def stackSafeCount(): Long = {
    veryLongList.foldLeft(0L)(_ + _)
  }

  def foldRight[A, B](as: List[A], z: B)(f: (A, B) => B): B = {
    as match {
      case Nil         => z
      case Cons(x, xs) => f(x, foldRight(xs, z)(f))
    }
  }

  private def initList: List[Int] = {
    (1000000 to 1 by -1).foldLeft(List.empty[Int])((acc, x) => Cons(x, acc))
  }

}
