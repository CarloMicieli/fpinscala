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

package io.github.carlomicieli
package fpinscala
package chapter09

/** EXERCISE 9.1] Using `product`, implement the now-familiar combinator `map2` and then use this to
  * implement `many1` in terms of `many`. Note that we could have chosen to make `map2`
  * primitive and defined `product` in terms of `map2` as we’ve done in previous chapters.
  * The choice is up to you.
  *
  * @example {{{
  *   def map2[A,B,C](p: Parser[A], p2: Parser[B])(f: (A,B) => C): Parser[C]
  * }}}
  */
trait Es9_01 {
}
