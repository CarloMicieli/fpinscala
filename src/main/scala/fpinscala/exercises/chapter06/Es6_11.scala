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
package fpinscala.exercises.chapter06

/**
  * EXERCISE 6.11] Hard: To gain experience with the use of `State`, implement a finite state automaton
  *                that models a simple candy dispenser. The machine has two types of input: you can
  *                insert a coin, or you can turn the knob to dispense candy. It can be in one of two
  *                states: locked or unlocked. It also tracks how many candies are left and how many
  *                coins it contains.
  */
object Es6_11 {
  sealed trait Input
  case object Coin extends Input
  case object Turn extends Input

  case class Machine(locked: Boolean, candies: Int, coins: Int) {
    val outOfCandies = candies == 0
  }

  type State[S, +A] = S => (A, S)
  type MchState = State[Machine, (Int, Int)]

  private def run(inp: Input): MchState = inp match {
    case Coin => addCoin
    case Turn => turnKnob
  }

  private val doNothing: MchState = mch => ((mch.coins, mch.candies), mch)

  private val addCoin: MchState = {
    case mch @ Machine(true, ca, co) if !mch.outOfCandies => ((co + 1, ca), Machine(false, ca, co + 1))
    case mch => doNothing(mch)
  }

  private val turnKnob: MchState = {
    case mch @ Machine(false, ca, co) if !mch.outOfCandies => ((co, ca - 1), Machine(true, ca - 1, co))
    case mch => doNothing(mch)
  }

  def simulateMachine(inputs: List[Input]): State[Machine, (Int, Int)] = inputs match {
    case List() => doNothing
    case i :: is =>
      mch => {
        val (_, m) = run(i)(mch)
        simulateMachine(is)(m)
      }
  }
}
