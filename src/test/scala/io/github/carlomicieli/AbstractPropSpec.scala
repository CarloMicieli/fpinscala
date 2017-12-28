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

package io.github.carlomicieli

import io.github.carlomicieli.fpinscala.chapter03.List
import org.scalacheck.{ Arbitrary, Gen }
import org.scalatest.PropSpec
import org.scalatest.prop.Checkers

import scala.reflect.ClassTag

abstract class AbstractPropSpec extends PropSpec with Checkers {

  def nonEmptyList[A](implicit a: Arbitrary[A]): Gen[List[A]] = {
    Gen.nonEmptyContainerOf[List, A](a.arbitrary)
  }

  def nonEmptyNegativeList[A](implicit n: Numeric[A], c: Gen.Choose[A]): Gen[List[A]] = {
    Gen.nonEmptyContainerOf[List, A](Gen.negNum[A])
  }

  def nonEmptyPosIntArray: Gen[Array[Int]] = {
    Gen.nonEmptyContainerOf[Array, Int](Gen.posNum[Int])
  }

  def nonEmptyArray[A: ClassTag](implicit a: Arbitrary[A]): Gen[Array[A]] = {
    Gen.nonEmptyContainerOf[Array, A](a.arbitrary)
  }

  def posIntArray: Gen[Array[Int]] = {
    Gen.containerOf[Array, Int](Gen.posNum[Int])
  }

}
