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
import io.github.carlomicieli.AbstractPropSpec

class Es5_01PropSpec extends AbstractPropSpec with Es5_01 {
  property("toList: produced list should have the same length as the original stream") {
    check(forAll { (s: Stream[Int]) =>
      toList(s).length ?= s.length
    })
  }

  property("toList: the produced list should have the same head as the original stream") {
    check(forAll { (x: Int, s: Stream[Int]) =>
      val stream = Stream.cons(x, s)
      stream.headOption ?= toList(stream).headOption
    })
  }

  property("toList: if the stream is empty the resulting list will be empty too") {
    check(forAll { (s: Stream[Int]) =>
      toList(s).isEmpty ?= s.isEmpty
    })
  }
}
