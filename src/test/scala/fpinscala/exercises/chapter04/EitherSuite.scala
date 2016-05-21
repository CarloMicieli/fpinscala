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

class EitherSuite extends FunSuite with Matchers {
  test("it should create Left or Right values") {
    val r = Right(42)
    val l = Left("no answer")
    r.value should be(42)
    l.value should be("no answer")
  }

  test("it should apply a function on Either values") {
    val r: Either[String, Int] = Right(42)
    val l: Either[String, Int] = Left("no answer")
    r.map(_ * 2) should be(Right(84))
    l.map(_ * 2) should be(Left("no answer"))
  }

  test("it should apply a function on Either values and flat the result") {
    val r: Either[String, Int] = Right(42)
    val r2: Either[String, Int] = Right(-42)
    val l: Either[String, Int] = Left("no answer")

    val f = (x: Int) => if (x > 0) Right(x * 2) else Left("wrong")

    r.flatMap(f) should be(Right(84))
    r2.flatMap(f) should be(Left("wrong"))
    l.flatMap(f) should be(Left("no answer"))
  }

  test("it should return an alternative value for Left values") {
    val r: Either[String, Int] = Right(42)
    val l: Either[String, Int] = Left("no answer")

    r.orElse(Right(0)) should be(Right(42))
    l.orElse(Right(0)) should be(Right(0))
  }

  test("it should combine two Either values") {
    val r1: Either[String, Int] = Right(21)
    val r2: Either[String, Int] = Right(2)
    val l: Either[String, Int] = Left("no answer")

    r1.map2(r2)(_ * _) should be(Right(42))
    r1.map2(l)(_ * _) should be(Left("no answer"))
    l.map2(r2)(_ * _) should be(Left("no answer"))
  }
}
