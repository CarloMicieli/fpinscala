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
package fpinscala.samples.chapter01

import Functions._
import org.scalacheck._

object MaxProperties extends Properties("max") {
  import org.scalacheck.Prop.{ forAll, BooleanOperators }

  property("must be one of the arguments") = forAll { (a: Int, b: Int) =>
    max(a, b) == a || max(a, b) == b
  }

  property("must be greater or equal of both arguments") = forAll { (a: Int, b: Int) =>
    val maxValue: Int = max(a, b)
    (maxValue >= a) && (maxValue >= b)
  }

  property("must find max when the two args are equals") = forAll { (a: Int) =>
    max(a, a) == a
  }

  property("must be the inverse of min") = forAll { (a: Int, b: Int) =>
    (max(a, b) != min(a, b)) ==> (a != b)
  }
}
