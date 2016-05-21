// Copyright (C) 2016 the original author or authors.
// See the LICENCE.txt file distributed with this work for additional
// information regarding copyright ownership.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package fpinscala.exercises.chapter03

/**
  * EXERCISE 3.24] Hard: As an example, implement `hasSubsequence` for checking whether a `List`
  *                contains another `List` as a subsequence. For instance, `List(1,2,3,4)` would have
  *                `List(1,2)`, `List(2,3)`, and `List(4)` as subsequences, among others. You may have
  *                some difficulty finding a concise purely functional implementation that is also
  *                efficient. That's okay. Implement the function however comes most naturally.
  *
  *                Note: Any two values `x` and `y` can be compared for equality in Scala using the expression `x == y`.
  */
object Es3_24 {
  def hasSubsequence[A](sup: List[A], sub: List[A]): Boolean = {
    val zero = (false, sub)
    val step: ((Boolean, List[A]), A) => (Boolean, List[A]) = (acc, x) => {
      val (isSub, matched) = acc
      matched match {
        case Nil       => (isSub, sub)
        case y Cons ys => if (x == y) (true, ys) else (false, sub)
      }
    }

    if (sub.isEmpty) true
    else {
      val (isSub, notMatched) = sup.foldLeft(zero)(step)
      isSub && notMatched.isEmpty
    }
  }
}