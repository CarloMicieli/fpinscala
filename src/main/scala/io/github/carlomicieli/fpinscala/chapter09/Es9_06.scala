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

package io.github.carlomicieli.fpinscala.chapter09

/** EXERCISE 9.6] Using flatMap and any other combinators, write the context-sensitive parser we
  * couldn’t express earlier. To parse the digits, you can make use of a new primitive,
  * regex , which promotes a regular expression to a Parser . 10 In Scala, a string s can
  * be promoted to a Regex object (which has methods for matching) using s.r , for
  * instance, "[a-zA-Z_][a-zA-Z0-9_]*".r .
  *
  * @example {{{
  *   implicit def regex(r: Regex): Parser[String]
  * }}}
  */
trait Es9_06 {
}
