/*
 * Copyright 2017 Carlo Micieli
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

package io.github.carlomicieli.fpinscala.chapter03

import org.scalacheck.Prop.{ forAll, AnyOperators }
import org.scalacheck.Gen._
import io.github.carlomicieli.AbstractPropSpec

class Es3_04PropSpec extends AbstractPropSpec with Es3_04 {

  property("drop(): shouldn't increase the list length") {
    check(forAll { (n: Int, xs: List[Int]) =>
      drop(xs, n).length <= xs.length
    })
  }

  property("drop(): should remove the first n elements, if they exist") {
    check(forAll(posNum[Int], nonEmptyList[Int]) { (n: Int, xs: List[Int]) =>
      val xs2 = drop(xs, n)
      xs2.length ?= math.max(xs.length - n, 0)
    })
  }

  property("drop(): the resulting list head should be the element at n position") {
    check(forAll(nonEmptyList[Int]) { (xs: List[Int]) =>
      forAll(choose(0, xs.length.toInt - 1)) { (n: Int) =>
        drop(xs, n).head ?= xs(n).get
      }
    })
  }

}
