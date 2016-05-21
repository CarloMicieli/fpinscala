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
package fpinscala.exercises.chapter06

/**
  * EXERCISE 6.4] Write a function to generate a list of random integers.
  */
object Es6_04 {
  def ints(count: Int)(rng: RNG): (List[Int], RNG) = {
    def step(n: Int, p: (List[Int], RNG)): (List[Int], RNG) = {
      val (xs, rng) = p
      val (n, rng2) = rng.nextInt
      (n :: xs, rng2)
    }

    (1 to count).toList.foldRight((List.empty[Int], rng))(step)
  }
}
