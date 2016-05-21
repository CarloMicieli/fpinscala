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
package fpinscala.exercises.chapter04

import org.scalatest.{ Matchers, FunSuite }
import Es4_07._

class Es4_07Suite extends FunSuite with Matchers {
  test("it should sequence a list of Either values") {
    val l1: List[Either[String, Int]] = List(Right(1), Right(2), Right(3))
    val l2: List[Either[String, Int]] = List(Right(1), Left("first error"), Right(3), Left("second error"))
    sequence(l1) should be(Right(List(1, 2, 3)))
    sequence(l2) should be(Left("first error"))
  }

  test("it should traverse a list of Either values") {
    val f: Int => Either[String, Int] = x => if (x > 0) Right(x) else Left("Negative")
    traverse(List(1, 2, 3))(f) should be(Right(List(1, 2, 3)))
    traverse(List(1, -2, 3))(f) should be(Left("Negative"))
  }
}
