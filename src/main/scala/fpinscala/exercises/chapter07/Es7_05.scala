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

package fpinscala.exercises.chapter07

import Par._

/**
  * EXERCISE 7.5] Hard: Write this function, called `sequence`. No additional primitives are required.
  *               Do not call `run`.
  */
object Es7_05 {
  def sequence[A](ps: List[Par[A]]): Par[List[A]] =
    ps.foldLeft(unit(List.empty[A]))(step)

  private def step[A](as: Par[List[A]], a: Par[A]): Par[List[A]] =
    Par.map2(a, as)(_ :: _)
}
