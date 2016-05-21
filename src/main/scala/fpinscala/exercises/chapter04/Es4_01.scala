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

/**
  * EXERCISE 4.1] Implement all of the preceding functions on `Option`. As you implement each function,
  *               try to think about what it means and in what situations you'd use it.
  */
object Es4_01 {

  def answer(n: Int): Option[String] =
    step1(n).map(v => 84 / v).flatMap(step2)

  private def step1(n: Int): Option[Int] =
    if (n > 0) Some(n) else None

  private def step2(n: Int): Option[String] =
    if (n == 42) Some("life universe and everything") else None
}
