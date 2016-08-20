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

package io.github.carlomicieli.fpinscala.chapter05

/**
  * EXERCISE 5.13] Use `unfold` to implement `map`, `take`, `takeWhile`, `zipWith` (as in chapter 3), and
  *                `zipAll`. The `zipAll` function should continue the traversal as long as either stream
  *                has more elements—it uses `Option` to indicate whether each stream has been
  *                exhausted.
  */
trait Es5_13 extends Es5_11 {
  def map[A, B](stream: Stream[A])(f: A => B): Stream[B] = {
    unfold(stream) {
      case Empty      => None
      case Cons(h, t) => Some((f(h()), t()))
    }
  }

  def take[A](stream: Stream[A])(n: Int): Stream[A] = {
    unfold((stream, n)) {
      case (Empty, _)      => None
      case (_, 0)          => None
      case (Cons(h, t), i) => Some((h(), (t(), i - 1)))
    }
  }

  def takeWhile[A](stream: Stream[A])(p: A => Boolean): Stream[A] = {
    unfold(stream) {
      case Empty => None
      case Cons(h, t) =>
        val head = h()
        if (p(head)) {
          Some((head, t()))
        } else {
          None
        }
    }
  }

  def zipWith[A, B](as: Stream[A], bs: Stream[A])(f: (A, A) => B): Stream[B] = {
    unfold((as, bs)) {
      case (Empty, _)                   => None
      case (_, Empty)                   => None
      case (Cons(ah, at), Cons(bh, bt)) => Some((f(ah(), bh()), (at(), bt())))
    }
  }

  def zipAll[A, B](as: Stream[A], bs: Stream[B]): Stream[(Option[A], Option[B])] = {
    unfold((as, bs)) {
      case (Empty, Empty)               => None
      case (Empty, Cons(h, t))          => Some(((None, Some(h())), (Empty, t())))
      case (Cons(h, t), Empty)          => Some(((Some(h()), None), (t(), Empty)))
      case (Cons(ah, at), Cons(bh, bt)) => Some(((Some(ah()), Some(bh())), (at(), bt())))
    }
  }
}
