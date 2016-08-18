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

package io.github.carlomicieli.fpinscala

import org.scalacheck.Gen
import org.scalacheck.Arbitrary
import org.scalacheck.util.Buildable
import org.scalatest.enablers.Length

package object chapter05 {

  implicit val streamLength: Length[Stream[_]] = new Length[Stream[_]] {
    def lengthOf(obj: Stream[_]): Long = obj.length.toLong
  }

  implicit def arbitraryStream[T](implicit a: Arbitrary[T]): Arbitrary[Stream[T]] = Arbitrary {
    import Arbitrary._
    import Gen._

    val genEmptyStream: Gen[Stream[T]] = Gen.const(Stream.empty[T])

    val genSingletonStream: Gen[Stream[T]] = for { x <- arbitrary[T] } yield Stream(x)

    def genConsStream: Gen[Stream[T]] = for {
      x <- arbitrary[T]
      s <- genStream
    } yield Stream.cons(x, s)

    def genStream = frequency((1, genEmptyStream), (1, genSingletonStream), (10, genConsStream))
    genStream
  }

  implicit def buildableStream[T]: Buildable[T, Stream[T]] = new Buildable[T, Stream[T]] {
    def builder = new scala.collection.mutable.Builder[T, Stream[T]]() {
      private var stream = Stream.empty[T]

      override def +=(elem: T): this.type = {
        stream = Stream.cons(elem, stream)
        this
      }

      override def result(): Stream[T] = stream
      override def clear(): Unit = {
        stream = Stream.empty[T]
      }
    }
  }

}
