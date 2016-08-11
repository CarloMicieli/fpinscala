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

object Es8_03Suite extends FunSuite with Matchers {
  test("it should implement &&") {
    val success = new Prop {
      def check = Right(50)
    }
    val failure = new Prop {
      def check = Left(("error", 42))
    }

    val p1 = success && success
    p1.check should be(Right(100))

    val p2 = success && failure
    val p3 = failure && failure
    p2.check should be(Left(("error", 42)))
    p3.check should be(Left(("error", 42)))
  }
}
