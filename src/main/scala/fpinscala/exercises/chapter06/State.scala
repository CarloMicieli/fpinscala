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

package fpinscala.exercises.chapter06

object State {
  type State[S, +A] = S => (A, S)

  def map[S, A, B](state: State[S, A])(f: A => B): State[S, B] = s => {
    val (a, s2) = state(s)
    (f(a), s2)
  }

  def map2[S, A, B, C](as: State[S, A], bs: State[S, B])(f: (A, B) => C): State[S, C] = s => {
    val (a, s2) = as(s)
    val (b, s3) = bs(s2)
    (f(a, b), s3)
  }

  def unit[S, A](a: A): State[S, A] = s => (a, s)

  def flatMap[S, A, B](state: State[S, A])(f: A => State[S, B]): State[S, B] = s => {
    val (a, s2) = state(s)
    f(a)(s2)
  }

  def sequence[S, A](fs: List[State[S, A]]): State[S, List[A]] = {
    def step(state: State[S, A], out: State[S, List[A]]): State[S, List[A]] = s => {
      val (la, lsa) = out(s)
      val (a, sa) = state(lsa)
      (a :: la, sa)
    }
    val zero = unit[S, List[A]](List.empty[A])
    fs.foldRight(zero)(step)
  }
}
