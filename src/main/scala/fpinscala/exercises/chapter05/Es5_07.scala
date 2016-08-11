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

package fpinscala.exercises.chapter05

/**
  * EXERCISE 5.7] Implement `map`, `filter`, `append`, and `flatMap` using `foldRight`.
  *               The `append` method should be non-strict in its argument.
  */
object Es5_07 {
  def map[A, B](stream: Stream[A])(f: A => B): Stream[B] =
    stream.foldRight(Stream.empty[B])((a, b) => Stream.cons(f(a), b))

  def filter[A](stream: Stream[A])(f: A => Boolean): Stream[A] =
    stream.foldRight(Stream.empty[A])((a, b) => if (f(a)) Stream.cons(a, b) else b)

  def append[A](a: Stream[A], b: => Stream[A]): Stream[A] =
    a.foldRight(b)((a, b) => Stream.cons(a, b))

  def flatMap[A, B](stream: Stream[A])(f: A => Stream[B]): Stream[B] =
    stream.foldRight(Stream.empty[B])((a, b) => f(a).append(b))
}
