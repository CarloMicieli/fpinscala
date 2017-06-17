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

trait SampleLists {
  val emptyList: List[Int] = List.empty[Int]

  val list: List[Int] = range2List(1 to 4)

  val listFrom1to10: List[Int] = range2List(1 to 10)

  private def range2List(r: Range): List[Int] = {
    r.foldRight(List.empty[Int])((x, xs) => Cons(x, xs))
  }
}
