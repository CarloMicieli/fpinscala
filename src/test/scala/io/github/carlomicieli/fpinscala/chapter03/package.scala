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

package io.github.carlomicieli.fpinscala

import scala.language.implicitConversions
import org.scalacheck.util.Buildable
import org.scalacheck.{ Arbitrary, Gen }
import org.scalatest.enablers.Length

package object chapter03 {
  implicit val listLength: Length[List[_]] = new Length[List[_]] {
    def lengthOf(obj: List[_]): Long = obj.length
  }

  implicit def listToTraversable[T](list: List[T]): Traversable[T] = new Traversable[T] {
    override def foreach[U](f: (T) => U): Unit = list.foreach(f)
  }

  implicit def arbitraryList[T](implicit a: Arbitrary[T]): Arbitrary[List[T]] = Arbitrary {
    import Arbitrary._
    import Gen._

    val genEmptyList = Gen.const(List.empty[T])

    val genSingletonList = for { x <- arbitrary[T] } yield List(x)

    def genList(sz: Int): Gen[List[T]] = containerOfN[List, T](sz, arbitrary[T])

    def sizedList(sz: Int) =
      if (sz <= 0) genEmptyList
      else Gen.frequency((1, genEmptyList), (1, genSingletonList), (8, genList(sz)))

    Gen.sized(sz => sizedList(sz))
  }

  implicit def buildableList[T]: Buildable[T, List[T]] = new Buildable[T, List[T]] {
    def builder = new scala.collection.mutable.Builder[T, List[T]]() {
      private var list = List.empty[T]

      override def +=(elem: T): this.type = {
        list = Cons(elem, list)
        this
      }

      override def result(): List[T] = list

      override def clear(): Unit = list = List.empty[T]
    }
  }
}
