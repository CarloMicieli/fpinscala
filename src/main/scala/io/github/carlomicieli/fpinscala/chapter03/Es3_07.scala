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

/** EXERCISE 3.7] Can `product`, implemented using `foldRight`, immediately halt the recursion and
  *              return `0.0` if it encounters a `0.0`? Why or why not? Consider how any
  *              short-circuiting might work if you call `foldRight` with a large list.
  */
trait Es3_07 {
  def product[A, B >: A](xs: List[A])(implicit num: Numeric[B]): B = {
    def continue(x: B, acc: => B): B = {
      if (x == num.zero) {
        x
      } else {
        acc
      }
    }

    foldRight(xs)(continue, num.one)(num.times)
  }

  // Lazy variant for the foldRight function
  // (source: http://voidmainargs.blogspot.de/2011/08/folding-stream-with-scala.html)
  def foldRight[A, B](xs: List[A])(continue: (A, => B) => B, z: B)(f: (A, B) => B): B = {
    xs match {
      case Nil        => z
      case Cons(h, t) => continue(h, f(h, foldRight(t)(continue, z)(f)))
    }
  }
}
