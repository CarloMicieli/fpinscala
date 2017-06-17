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

package io.github.carlomicieli.fpinscala.chapter07

import Par._

/** EXERCISE 7.4] This API already enables a rich set of operations. Here's a simple example: using
  *              `lazyUnit`, write a function to convert any function `A => B` to one that evaluates
  *              its result asynchronously.
  */
trait Es7_04 {
  def asyncF[A, B](f: A => B): A => Par[B] = a => Par.lazyUnit(f(a))
}
