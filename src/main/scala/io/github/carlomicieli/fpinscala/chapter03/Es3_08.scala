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

package io.github.carlomicieli.fpinscala.chapter03

/** EXERCISE 3.8] See what happens when you pass `Nil` and `Cons` themselves to `foldRight`,
  *             like this:
  * @example {{{
  *       foldRight(List(1,2,3), Nil:List[Int])(Cons(_,_))
  * }}}
  *             What do you think this says about the relationship between
  *             `foldRight` and the data constructors of `List`?
  */
trait Es3_08 {
}
