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

package io.github.carlomicieli.fpinscala.chapter04

/** EXERCISE 4.7] Implement `sequence` and `traverse` for `Either`. These should return
  *             the first error that's encountered, if there is one.
  */
trait Es4_07 {
  def sequence[E, A](es: List[Either[E, A]]): Either[E, List[A]] = traverse(es)(identity)

  def traverse[E, A, B](as: List[A])(f: A => Either[E, B]): Either[E, List[B]] = {
    val fu = step[E, A, B](f) _
    as.foldRight(zero[E, B])(fu)
  }

  private def zero[E, B]: Either[E, List[B]] = Right(List.empty[B])

  private def step[E, A, B](f: A => Either[E, B])(x: A, acc: Either[E, List[B]]): Either[E, List[B]] = {
    (f(x), acc) match {
      case (l @ Left(_), _)      => l
      case (_, l @ Left(_))      => l
      case (Right(y), Right(ys)) => Right(y :: ys)

    }
  }
}
