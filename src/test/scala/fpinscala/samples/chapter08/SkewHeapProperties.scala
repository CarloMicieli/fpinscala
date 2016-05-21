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
package fpinscala.samples.chapter08

import org.scalacheck._

object SkewHeapProperties extends Properties("ShewHeap") {
  import Prop.forAll
  import Arbitrary.arbitrary
  import Gen.{ frequency, const }

  implicit def arbitraryHeap(implicit a: Arbitrary[Int]): Arbitrary[SkewHeap[Int]] =
    Arbitrary {
      val genEmpty: Gen[SkewHeap[Int]] = const(SkewHeap.empty[Int])

      def genUnit: Gen[SkewHeap[Int]] = for {
        n <- arbitrary[Int]
      } yield Fork(n, Empty, Empty)

      def genFork: Gen[SkewHeap[Int]] = for {
        n <- arbitrary[Int]
        h <- genHeap
      } yield h.insert(n)

      def genHeap: Gen[SkewHeap[Int]] =
        frequency((1, genEmpty), (2, genUnit), (3, genFork))

      genHeap
    }

  implicit def arbitraryOp(implicit a: Arbitrary[Int]): Arbitrary[Op] =
    Arbitrary {
      import Gen.frequency

      val genInsOp = for { n <- arbitrary[Int] } yield Insert(n)
      val genDelMin = const(DeleteMin)

      frequency((2, genInsOp), (1, genDelMin))
    }

  property("prop_invariant") = forAll { (xs: List[Op]) =>
    val h = Ops.toHeap(xs)
    h.isValid
  }

  property("prod_balanced") = forAll { (xs: List[Int]) =>
    val h = SkewHeap.fromList(xs)
    h.isBalanced
  }

  property("prop_weight") = forAll { (xs: List[Int]) =>
    val h = SkewHeap.fromList(xs)
    h.weight == xs.size
  }

  property("insert keeps the invariant") = forAll { (h: SkewHeap[Int], x: Int) =>
    val modifiedHeap = h.insert(x)
    modifiedHeap.isValid
  }

  property("insert produce balanced heaps") = forAll { (h: SkewHeap[Int], x: Int) =>
    h.insert(x).isBalanced
  }

  property("deleteMin keeps the invariant") = forAll { (h: SkewHeap[Int]) =>
    h.deleteMin.isValid
  }

}
