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
import Es4_08._

class Es4_08Suite extends FunSuite with Matchers {

  test("it should append validation values") {
    val Success(n) = positive(7) +++ positive(10) +++ positive(25)
    assert(n == 42)
  }

  test("it should validate a Person") {
    val Success(values) = mkPerson("John Doe", 42)
    values should be(List("John Doe", 42))

    val Failure(errors) = mkPerson("", -10)
    errors should be(List("Name is empty.", "Age is out of range."))
  }

  def positive(i: Int): Validation[List[String], Int] = {
    if (i > 0) Success(i)
    else Failure(List(s"Non positive integer $i"))
  }
}
