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

package io.github.carlomicieli.fpinscala.chapter08

trait Prop {
  import Prop._

  def check: Either[(FailedCase, SuccessCount), SuccessCount]
  def &&(that: Prop): Prop = new Prop {
    def check = for {
      x <- this.check.right
      y <- that.check.right
    } yield x + y
  }
}

object Prop {
  type SuccessCount = Int
  type FailedCase = String

  def forAll[A](a: Gen[A])(p: A => Boolean): Prop = ???
}
