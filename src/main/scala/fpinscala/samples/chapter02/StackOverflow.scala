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

// WARNING: Long return types will likely cause overflow computing sums
//          The purpose of this code is to test stack overflow errors and
//          tail call optimization.
//          Unable to keep this code under test as sum2 is slow, and extremely
//          slow using BigInt.
object StackOverflow {

  // sum from math (Gauss formula)
  def sum(n: Int): Long = (n * (n + 1) / 2).toLong

  // recursive sum of integer from 0 to n
  def sum1(n: Int): Long = n match {
    case 0 => 0
    case _ => n + sum1(n - 1)
  }

  //tail optimized recursive sum of integer from 0 to n
  def sum2(n: Int): Long = {
    @annotation.tailrec
    def loop(i: Int, acc: Long): Long = i match {
      case 0 => acc
      case _ => loop(i + 1, i + acc)
    }

    loop(n, 0)
  }
}