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
import Es5_02._

class Es5_02Suite extends FunSuite {
  test("it should take n elements from a stream") {
    assert(takeFromStream(Stream(1, 2, 3, 4), 2) == List(1, 2))
    assert(Stream(1, 2, 3).take(0).toList == List())
    assert(Stream(1, 2, 3).take(1).toList == List(1))
    assert(Stream(1, 2, 3).take(6).toList == List(1, 2, 3))
  }

  test("it should drop n elements from a stream") {
    assert(dropFromStream(Stream(1, 2, 3, 4), 2) == List(3, 4))
    assert(Stream(1, 2, 3).drop(0).toList == List(1, 2, 3))
    assert(Stream(1, 2, 3).drop(4).toList == List())
  }
}
