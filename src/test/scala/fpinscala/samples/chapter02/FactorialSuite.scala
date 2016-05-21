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

import org.scalatest.FunSuite
import Factorial._

class FactorialSuite extends FunSuite {

  test("factorial of 5 is 120") {
    val hundredAndTwenty = BigInt(120)
    assert(fact1(5) == hundredAndTwenty)
    assert(fact2(5) == hundredAndTwenty)
    assert(fact3(5) == hundredAndTwenty)
    assert(fact4(5) == hundredAndTwenty)
  }

  test("it should return the first 7 factorials") {
    val list = stream.take(7).toList
    assert(list == List(BigInt(1), BigInt(2), BigInt(6), BigInt(24), BigInt(120), BigInt(720), BigInt(5040)))
  }
}
