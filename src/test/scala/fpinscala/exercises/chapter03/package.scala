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
package fpinscala.exercises

import org.scalacheck.{ Arbitrary, Gen }
import org.scalacheck.util.Buildable

import scala.collection.mutable
import scala.language.implicitConversions

package object chapter03 {

  implicit def listToTraversable[T](list: List[T]): Traversable[T] = new Traversable[T] {
    override def foreach[U](f: (T) => U): Unit = list.foreach(f)
  }

  implicit def arbList[T](implicit a: Arbitrary[T]): Arbitrary[List[T]] = Arbitrary {
    val genEmptyList = Gen.const(List.empty[T])
    val genSingletonList = for (e <- Arbitrary.arbitrary[T]) yield List(e)

    def genList(sz: Int): Gen[List[T]] = Gen.containerOfN[List, T](sz, Arbitrary.arbitrary[T])

    def sizedList(sz: Int) =
      if (sz <= 0) genEmptyList
      else Gen.frequency((1, genEmptyList), (1, genSingletonList), (8, genList(sz)))

    Gen.sized(sz => sizedList(sz))
  }

  implicit def buildableList[T]: Buildable[T, List[T]] = new Buildable[T, List[T]] {
    def builder = new mutable.Builder[T, List[T]]() {
      private var list = List.empty[T]

      override def +=(elem: T): this.type = {
        list = elem :: list
        this
      }

      override def result(): List[T] = list

      override def clear(): Unit = list = List.empty[T]
    }
  }
}
