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

package io.github.carlomicieli.fpinscala.chapter07

import Par._

/**
  * EXERCISE 7.12] There’s still something rather arbitrary about choiceN. The choice of List seems
  *                overly specific. Why does it matter what sort of container we have? For instance, what
  *                if, instead of a list of computations, we have a Map of them
  */
trait Es7_12 {
  def choiceMap[K, V](key: Par[K])(choices: Map[K, Par[V]]): Par[V] = ???
}
