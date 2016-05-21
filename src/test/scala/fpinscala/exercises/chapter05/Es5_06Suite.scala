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
package fpinscala.exercises.chapter05

import org.scalatest.FunSuite
import Es5_06._

class Es5_06Suite extends FunSuite {
  test("it should return None as head for empty streams") {
    assert(headOption(Stream.empty[Int]) == None)
  }

  test("it should return Some value as head for non empty streams") {
    assert(headOption(Stream.of(1, 2, 3)) == Some(1))
    assert(headOption(Stream.from(42)) == Some(42))
  }
}
