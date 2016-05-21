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
import Es5_07._

class Es5_07Suite extends FunSuite {
  test("it should implement map using foldRight") {
    val f: Int => Int = _ * 2
    val s = Stream.of(1, 2, 3, 4)

    assert(map(s)(f).toList == List(2, 4, 6, 8))
    assert(map(Stream.from(1))(f).take(2).toList == List(2, 4))
  }

  test("it should implement filter using foldRight") {
    val f: Int => Boolean = _ % 2 == 0
    val s = Stream.of(1, 2, 3, 4)

    assert(filter(s)(f).toList == List(2, 4))
    assert(filter(Stream.from(42))(f).take(5).toList == List(42, 44, 46, 48, 50))
  }

  test("it should append two streams using foldRight") {
    val s1 = Stream.of(1, 2, 3, 4)
    val s2 = Stream.from(5)

    def error: Stream[Int] = throw new NoSuchElementException("")

    assert(append(s1, s2).take(5).toList == (1 to 5).toList)
    assert(append(s2, s1).take(5).toList == (5 until 10).toList)
    assert(append(s2, s2).take(5).toList == (5 until 10).toList)
    assert(append(s2, error).take(5).toList == (5 until 10).toList)
  }

  test("it should implement flatMap using foldRight") {
    val s1 = Stream.of(1, 2, 3, 4)
    val s2 = Stream.from(5)

    val f: Int => Stream[Int] = x => Stream.of(2 * x)

    assert(flatMap(s1)(f).toList == List(2, 4, 6, 8))
    assert(flatMap(s2)(f).take(5).toList == List(10, 12, 14, 16, 18))
  }
}
