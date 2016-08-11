/*
 * Copyright 2016 Carlo Micieli
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package fpinscala.exercises.chapter08

import org.scalatest.{ Matchers, FunSuite }
import org.scalatest.prop.PropertyChecks
import Es8_01._

class Es8_01Suite extends FunSuite with PropertyChecks with Matchers {

  test("list sum") {
    forAll { (xs: List[Int]) =>
      sum(xs) should be(xs.sum)
    }
  }

  test("list sum: reverse") {
    forAll { (xs: List[Int]) =>
      sum(xs) should be(sum(xs.reverse))
    }
  }

  test("list sum: concat") {
    forAll { (xs: List[Int], ys: List[Int]) =>
      sum(xs ::: ys) should be(sum(xs) + sum(ys))
    }
  }

  test("list sum: cons") {
    forAll { (xs: List[Int], x: Int) =>
      sum(x :: xs) should be(x + sum(xs))
    }
  }

  ignore("list sum: summing the same element") {
    forAll { (size: Int) =>
      whenever(size >= 0) {
        val xs = replicate(1, size)
        sum(xs) should be(xs.size)
      }
    }
  }
}
