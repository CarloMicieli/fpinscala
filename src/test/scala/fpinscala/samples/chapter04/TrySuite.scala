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
package fpinscala.samples.chapter04

import fpinscala.exercises.chapter04.{ None, Some }
import org.scalatest.{ FunSuite, Matchers }

import scala.util.control.NoStackTrace

class TrySuite extends FunSuite with Matchers {
  test("it should create a new Try value for successful computations") {
    val success = Try(42)
    success.isSuccess should be(true)
    success.isFailure should be(false)
    success.get should be(42)
  }

  test("it should create a new Try value for failed computations") {
    val fail = Try { val v = 12 / 0; v }
    fail.isFailure should be(true)
    fail.isSuccess should be(false)
    fail.exception.isEmpty should be(false)
  }

  test("it should apply a function to Try values") {
    val success = Try(21)
    val fail = Try { val v = 12 / 0; v }
    val f: Int => Int = _ * 2
    success.map(f).get should be(42)
    fail.map(f) should be(fail)
  }

  test("it should apply a function to Try values and then flatten the result") {
    val success = Try(21)
    val fail = Try { val v = 12 / 0; v }
    val f: Int => Try[Int] = x => Success(x * 2)
    success.flatMap(f).get should be(42)
    fail.flatMap(f) should be(fail)
  }

  test("it should recover Try values") {
    val success = Try(21)
    val fail = Failure(new NoSuchElementException with NoStackTrace)

    val recoveringFun: PartialFunction[Throwable, Try[Int]] = {
      case x: NoSuchElementException => Success(42)
    }

    success.recoverWith(recoveringFun) should be(success)
    fail.recoverWith(recoveringFun) should be(Success(42))
  }

  test("it should filter a Try value") {
    val success = Try(42)
    val fail = Try { val v = 12 / 0; v }

    success.filter(_ % 2 == 0) should be(success)
    success.filter(_ % 2 != 0).isFailure should be(true)
    fail.filter(_ % 2 != 0).isFailure should be(true)
  }

  test("it should convert a Try value into an Option") {
    val success = Success(42)
    val fail = Failure(new Exception with NoStackTrace)

    success.toOption should be(Some(42))
    fail.toOption should be(None)
  }

  test("it should return the wrapped value, of a default if it is a Failure") {
    val success = Success(42)
    val fail = Failure(new Exception with NoStackTrace)

    success.getOrElse(-1) should be(42)
    fail.getOrElse(-1) should be(-1)
  }

  test("it should flatten Try values") {
    val v = Try(Try(42))
    v.flatten should be(Try(42))
  }
}
