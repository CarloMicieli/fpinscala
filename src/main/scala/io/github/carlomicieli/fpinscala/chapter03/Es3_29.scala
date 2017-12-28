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

/** EXERCISE 3.29] Generalize `size`, `maximum`, `depth`, and `map`, writing a new
  *              function `fold` that abstracts over their similarities.
  *              Implement them in terms of this more general function. Can
  *              you draw an analogy between this fold function and the left and right
  *              folds for List ?
  */
trait Es3_29 {
  def fold[A, B](t: Tree[A])(f: (A) => B)(g: (B, B) => B): B = t match {
    case Leaf(n) => f(n)
    case Branch(l, r) =>
      val v1 = fold(l)(f)(g)
      val v2 = fold(r)(f)(g)
      g(v1, v2)
  }

  def size[A](t: Tree[A]): Int = {
    fold[A, Int](t)((x) => 1)((l, r) => l + r)
  }

  def depth[A](t: Tree[A]): Int = {
    fold[A, Int](t)((x) => 0)((l, r) => 1 + math.max(l, r))
  }

  def maximum[A](t: Tree[A])(implicit ord: Ordering[A]): A = {
    fold[A, A](t)(v => v)((l, r) => ord.max(l, r))
  }

  def map[A, B](t: Tree[A], f: A => B): Tree[B] = {
    fold[A, Tree[B]](t)(v => Leaf(f(v)))((l, r) => Branch(l, r))
  }
}
