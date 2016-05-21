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
package fpinscala.samples.chapter02

object Factorial {

  def fact1(n: Int): BigInt = n match {
    case 0 => 1
    case _ => n * fact1(n - 1)
  }

  def fact2(n: Int): BigInt = {
    @annotation.tailrec
    def loop(i: Int, acc: BigInt): BigInt = {
      if (i <= 1) acc
      else loop(i - 1, i * acc)
    }

    loop(n, 1)
  }

  def fact3(n: Int): BigInt = (1 to n).product

  def fact4(n: Int): BigInt = {
    var fact: BigInt = 1
    var i = 1

    while (i <= n) {
      fact = fact * i
      i = i + 1
    }

    fact
  }

  // (lazy) stream for factorials
  val stream: Stream[BigInt] = {
    def loop(n: Int, prev: BigInt): Stream[BigInt] = {
      val fact = n * prev
      fact #:: loop(n + 1, fact)
    }
    loop(1, 1)
  }
}

// Binomial coefficient
//  http://en.wikipedia.org/wiki/Combination
object BinCoefficient {

  implicit class IntFact(val n: Int) extends AnyVal {
    def ! = Factorial.fact2(n)
  }

  import scala.language.postfixOps

  def apply(n: Int, k: Int): BigInt = {
    (n !) / ((k !) * ((n - k) !))
  }
}
