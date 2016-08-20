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

package io.github.carlomicieli.fpinscala.chapter06

import RNG._

/**
  * EXERCISE 6.9] Reimplement `map` and `map2` in terms of `flatMap`. The fact that this is possible is what
  *               we’re referring to when we say that `flatMap` is more powerful than `map` and `map2`.
  */
trait Es6_09 {
  def map[A, B](s: Rand[A])(f: A => B): Rand[B] = flatMap(s)(i => unit(f(i)))

  def map2[A, B, C](ra: Rand[A], rb: Rand[B])(f: (A, B) => C): Rand[C] =
    flatMap(ra)(a => flatMap(rb)(b => unit(f(a, b))))
}
