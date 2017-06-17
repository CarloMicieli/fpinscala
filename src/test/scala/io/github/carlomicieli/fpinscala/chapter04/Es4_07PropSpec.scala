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

package io.github.carlomicieli.fpinscala.chapter04

import org.scalacheck.Prop.{ forAll, AnyOperators }
import org.scalacheck.Gen._
import io.github.carlomicieli.AbstractPropSpec

class Es4_07PropSpec extends AbstractPropSpec with Es4_07 {
  property("sequence(): should return the first Left encountered, if any") {
    check(forAll { (xs: List[Either[String, Int]]) =>
      val res = sequence(xs)
      if (xs.forall(_.isRight))
        res.isRight
      else
        res.isLeft
    })
  }

  property("sequence(): collect all values for Right") {
    check(forAll(nonEmptyListOf[Int](posNum[Int])) { (xs: List[Int]) =>
      val ys = xs.map(x => Either.right[Int](x))
      sequence(ys) match {
        case Right(v) => v ?= xs
        case Left(_)  => true ?= false
      }
    })
  }

  property("traverse(): apply function to Right values") {
    check(forAll(nonEmptyListOf[Int](posNum[Int])) { (xs: List[Int]) =>
      val ys = xs.map(x => Either.right[Int](x))
      traverse(ys)(x => Either.right(x.toString)) match {
        case Right(v) => v ?= ys.map(_.toString)
        case Left(_)  => true ?= false
      }
    })
  }
}
