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

package io.github.carlomicieli.fpinscala.chapter07

import Par._

/** EXERCISE 7.6] Implement `parFilter`, which filters elements of a list in parallel.
  */
trait Es7_06 {
  def parFilter[A](as: List[A])(f: A => Boolean): Par[List[A]] = {
    val len = as.length
    if (len <= 1)
      unit(as.filter(f))
    else {
      val (l, r) = as.splitAt(len / 2)
      map2(fork(parFilter(l)(f)), fork(parFilter(r)(f)))(_ ++ _)
    }
  }
}
