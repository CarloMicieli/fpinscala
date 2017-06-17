/*
 * Copyright 2017 CarloMicieli
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

package io.github.carlomicieli.fpinscala.chapter05

import org.scalacheck.Prop.{ forAll, AnyOperators }
import org.scalacheck.Gen._
import io.github.carlomicieli.AbstractPropSpec

class Es5_02PropSpec extends AbstractPropSpec with Es5_01 with Es5_02 {
  property("appending the results from take and drop returns the original stream elements") {
    check(forAll { (s: Stream[Int]) =>
      forAll(choose(0, s.length)) { (n: Int) =>
        val s2 = take(s)(n) append drop(s)(n)
        toList(s2) ?= toList(s)
      }
    })
  }
}
