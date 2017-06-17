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

package io.github.carlomicieli.fpinscala.chapter07

import Executors._

class ParTestSpec extends Chapter7Spec {
  describe("Par") {
    describe("unit") {
      ignore("should create a Par from a value") {
        val fixedComputation = Par.unit[Int](42)
        Par.run(singleThreadPool)(fixedComputation).get() shouldBe 42
      }
    }

    describe("lazyUnit") {
      ignore("should create a Par from a value") {
        val fixedComputation = Par.lazyUnit[Int](42)
        Par.run(fixedThreadPool)(fixedComputation).get() shouldBe 42
      }
    }

    describe("map2") {
      ignore("should combine two computations") {
        val pa = Par.unit(21)
        val pb = Par.unit(21)
        val computation = Par.map2(pa, pb)(_ + _)
        Par.run(singleThreadPool)(computation).get() shouldBe 42
      }
    }
  }
}
