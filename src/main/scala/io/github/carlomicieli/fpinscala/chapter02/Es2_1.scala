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

package io.github.carlomicieli.fpinscala.chapter02

/**
  * EXERCISE 2.1] Write a recursive function to get the nth Fibonacci number (http://mng.bz/C29s).
  *               The first two Fibonacci numbers are 0 and 1 . The nth number is always the sum of the
  *               previous two—the sequence begins 0, 1, 1, 2, 3, 5 . Your definition should use a
  *               local tail-recursive function.
  */
trait Es2_1 {
  def fib(n: Int): BigInt = {
    require(n >= 0)

    @annotation.tailrec
    def loop(i: Int, acc: (BigInt, BigInt)): BigInt = {
      if (i == 0) {
        acc._1
      } else {
        val (f1, f2) = acc
        loop(i - 1, (f2, f1 + f2))
      }
    }

    loop(n, (0, 1))
  }
}
