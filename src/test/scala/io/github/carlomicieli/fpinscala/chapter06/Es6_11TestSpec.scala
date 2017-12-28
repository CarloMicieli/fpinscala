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

package io.github.carlomicieli.fpinscala.chapter06

class Es6_11TestSpec extends Chapter6Spec with Es6_11 {
  describe("Es6.11") {
    it("should simulate a candy machine") {
      val mch = Machine(true, 5, 10)
      val inputs = List(Coin, Turn, Coin, Turn, Coin, Turn, Coin, Turn)

      val (_, mch2) = simulateMachine(inputs)(mch)

      //TODO: check this
      //assert(a == (14, 1))
      mch2.candies shouldBe 1
      mch2.coins shouldBe 14
    }

    it("should do nothing if there is no candies") {
      val mch = Machine(true, 0, 10)
      val inputs = List(Coin, Turn)

      val (_, mch2) = simulateMachine(inputs)(mch)

      //TODO: check this
      //assert(a == (10, 0))
      mch shouldBe mch2
    }

    it("should do nothing if the machine is already unlocked") {
      val mch = Machine(false, 0, 10)
      val inputs = List(Turn)

      val (_, mch2) = simulateMachine(inputs)(mch)
      mch shouldBe mch2
    }
  }
}