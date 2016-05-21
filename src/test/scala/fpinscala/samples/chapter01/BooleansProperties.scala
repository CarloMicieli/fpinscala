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

import Booleans._
import org.scalacheck._

object AndAlsoProperties extends Properties("andAlso") {
  import Prop.forAll

  property("must return the same value as built in operator") = forAll { (a: Boolean, b: Boolean) =>
    andAlso(a, b) == (a && b)
  }

  property("must always return 'false' when one argument is false") = forAll { (a: Boolean) =>
    !andAlso(a, false)
  }

  property("must return the argument when they are the same") = forAll { (a: Boolean) =>
    andAlso(a, a) == a
  }
}

object OrElseProperties extends Properties("orElse") {
  import Prop.forAll

  property("must return the same result as the builtin operator") = forAll { (a: Boolean, b: Boolean) =>
    orElse(a, b) == (a || b)
  }

  property("must always return 'true' when one argument is true") = forAll { (a: Boolean) =>
    orElse(a, true)
  }
}

object ExOrProperties extends Properties("exOr") {
  import Prop.forAll

  property("must return 'true' when exactly one argument is 'true'") = forAll { (a: Boolean) =>
    exOr(a, !a)
  }

  property("must have the right behaviour over booleans") = forAll { (a: Boolean, b: Boolean) =>
    exOr(a, b) == (a != b)
  }

}