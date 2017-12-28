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

package io.github.carlomicieli.fpinscala.chapter02

import io.github.carlomicieli.AbstractPropSpec
import org.scalacheck.Gen
import Gen._
import org.scalacheck.Prop.{ forAll, BooleanOperators }

class Es2_1PropSpec extends AbstractPropSpec with Es2_1 {

  property("fib: nth fibonacci number is greater or equal to n-1 th number") {
    check(forAll(posNum[Int]) { (n: Int) =>
      fib(n) >= fib(n - 1)
    })
  }

  property("fib: fibonacci number is always non negative") {
    check(forAll(posNum[Int]) { (n: Int) =>
      fib(n) >= 0
    })
  }

  property("fib: nth fibonacci number is the sum of n-1 th and n-2 th numbers") {
    check(forAll(posNum[Int]) { (n: Int) =>
      (n > 2) ==> {
        fib(n) === fib(n - 1) + fib(n - 2)
      }
    })
  }

}
