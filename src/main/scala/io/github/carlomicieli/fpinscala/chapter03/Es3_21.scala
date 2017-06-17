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

/** EXERCISE 3.21] Use `flatMap` to implement `filter`.
  */
trait Es3_21 extends Es3_20 {
  def filter[A](as: List[A])(p: A => Boolean): List[A] = {
    flatMap(as)(x => if (p(x)) List(x) else List())
  }
}
