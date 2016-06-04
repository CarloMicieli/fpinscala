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
package io.github.carlomicieli.fpinscala

import org.scalacheck.{ Arbitrary, Gen }

package object chapter04 {
  implicit def arbitraryOption[T](implicit a: Arbitrary[T]): Arbitrary[Option[T]] = Arbitrary {
    val genNone: Gen[Option[T]] = Gen.const(Option.none[T])

    def genJust: Gen[Option[T]] = for { x <- a.arbitrary } yield Option.just(x)

    Gen.oneOf(genNone, genJust)
  }

  implicit def arbitraryEither[E, T](implicit arbE: Arbitrary[E], arbT: Arbitrary[T]): Arbitrary[Either[E, T]] = Arbitrary {
    val genLeft = for { e <- arbE.arbitrary } yield Either.left(e)
    val genRight = for { t <- arbT.arbitrary } yield Either.right(t)
    Gen.oneOf(genLeft, genRight)
  }
}
