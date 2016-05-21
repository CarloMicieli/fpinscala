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
package fpinscala.exercises.chapter04

import org.scalatest.{ Matchers, FunSuite }
import Es4_02._

class Es4_02Suite extends FunSuite with Matchers {
  test("it should find the variance of a sequence") {
    val numbers = Seq(1.0, 5.0, 15.0, 42.0, 52.0, 99.0)
    mean(numbers) should be(Some(36.0))
    variance(numbers) should be(Some(1148.0))
  }
}
