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
  * EXERCISE 5.5] Use `foldRight` to implement `takeWhile`.
  */
object Es5_05 {
  def takeWhile[A](stream: Stream[A])(p: A => Boolean): Stream[A] = {
    def step(x: A, xs: => Stream[A]): Stream[A] =
      if (p(x))
        Stream.cons(x, xs)
      else
        Stream.empty[A]

    stream.foldRight(Stream.empty[A])(step)
  }
}
