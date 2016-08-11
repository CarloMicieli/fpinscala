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

package fpinscala.exercises.chapter06

import org.scalatest.FunSuite
import RNG._

class RNGSuite extends FunSuite {
  test("it should produce pseudo-random numbers") {
    val rng = SimpleRNG(42)
    val (n1, rng2) = rng.nextInt
    assert(n1 == 16159453)

    val (n2, _) = rng2.nextInt
    assert(n2 == -1281479697)
  }

  test("it should generate a random pair of numbers") {
    val rng = SimpleRNG(42)
    val ((n1, n2), _) = rng.randomPair
    assert(n1 == 16159453)
    assert(n2 == -1281479697)
  }

  test("it should generate a double number between 0 and 1") {
    val rng = SimpleRNG(42)
    val (d, _) = rng.nextDouble
    assert(d == 0.007524831689672932)
    assert(d >= 0.0 && d < 1.0)
  }

  test("it should produce a const value") {
    val (n, _) = unit(15)(SimpleRNG(42))
    assert(n == 15)
  }

  test("it should map a function over a random generator") {
    val (str, _) = map(unit(42))(_.toString)(SimpleRNG(1))
    assert(str == "42")
  }

  test("it should flatMap a function over a random generator") {
    val (str, _) = flatMap(unit(42))(i => unit(s"($i)"))(SimpleRNG(42))
    assert(str == "(42)")
  }

  test("it should get values from both random generators") {
    val ((n1, n2), _) = both(_.nextInt, _.nextInt)(SimpleRNG(42))
    assert(n1 == 16159453)
    assert(n2 == -1281479697)
  }
}
