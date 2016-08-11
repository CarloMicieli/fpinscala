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
  * EXERCISE 5.10] Write a function fibs that generates the infinite stream of Fibonacci numbers:
  *                 0, 1, 1, 2, 3, 5, 8, and so on.
  */
object Es5_10 {
  def fibs: Stream[Int] = Stream.of(0, 1).append(nextFib(0, 1))

  private def nextFib(n1: Int, n2: Int): Stream[Int] = {
    val next = n1 + n2
    Stream.cons(next, nextFib(n2, next))
  }
}
