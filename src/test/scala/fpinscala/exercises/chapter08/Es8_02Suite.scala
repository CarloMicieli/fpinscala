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
package fpinscala.exercises.chapter08

import org.scalatest.{ Matchers, FunSuite }
import org.scalatest.prop.PropertyChecks
import Es8_02._

class Es8_02Suite extends FunSuite with PropertyChecks with Matchers {

  test("list max: contained in list") {
    forAll { (xs: List[Int]) =>
      whenever(xs.nonEmpty) {
        val max = maximum(xs)
        xs.contains(max) should be(true)
      }
    }
  }

  test("list max: no element is bigger") {
    forAll { (xs: List[Int]) =>
      whenever(xs.nonEmpty) {
        val max = maximum(xs)
        xs.exists(_ > max) should be(false)
      }
    }
  }

  test("list max: is the biggest element") {
    forAll { (xs: List[Int]) =>
      whenever(xs.nonEmpty) {
        val max = maximum(xs)
        xs.forall(_ <= max) should be(true)
      }
    }
  }

  test("list max: cons") {
    forAll { (xs: List[Int], x: Int) =>
      whenever(xs.nonEmpty) {
        maximum(x :: xs) should be(math.max(x, maximum(xs)))
      }
    }
  }
}
