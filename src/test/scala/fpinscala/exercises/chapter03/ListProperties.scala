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
package fpinscala.exercises.chapter03

import org.scalacheck._

object ListProperties extends Properties("list") {

  import Prop.forAll

  property("cons increase length by 1") = forAll { (x: Int, xs: List[Int]) =>
    val ys = x :: xs
    !ys.isEmpty
    xs.length + 1 == ys.length
  }

  property("appended list size is the sum of two original lists length") =
    forAll { (xs: List[Int], ys: List[Int]) =>
      (xs.length + ys.length) == (xs ++ ys).length
    }

  property("map over two functions or over their composition yield the same result") =
    forAll { (xs: List[Int]) =>
      val f: Int => Int = x => x * 2
      val g: Int => Int = x => x + 1

      xs.map(g).map(f) == xs.map(f.compose(g))
      xs.map(f).map(g) == xs.map(f.andThen(g))
    }

  property("reverse and append can be switched") = forAll { (xs: List[Int], ys: List[Int]) =>
    (xs.reverse ++ ys.reverse) == (ys ++ xs).reverse
  }

  property("sum after mapping a function or apply the function to the sum yields the same result") =
    forAll { (xs: List[Int]) =>
      val f: Int => Int = x => x * 2
      xs.map(f).sum == f(xs.sum)
    }
}
