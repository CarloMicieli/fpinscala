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
package io.github.carlomicieli.fpinscala.chapter03

import org.scalacheck.Prop.forAll
import io.github.carlomicieli.AbstractPropSpec

class Es3_21PropSpec extends AbstractPropSpec with Es3_21 {
  property("filter(): shouldn't add new elements to the list") {
    check(forAll { (cs: List[Char]) =>
      filter(cs)(_.isLetter).length <= cs.length
    })
  }
  /*
  property("filter(): produces the empty list when no element matches the predicate") {
    check(forAll(nonEmptyList[Char]) {(cs: List[Char]) =>

    })
  }
*/
  val greaterThan42: Int => Boolean = _ > 42
}
