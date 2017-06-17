/*
 * Copyright 2017 CarloMicieli
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

package io.github.carlomicieli.fpinscala.chapter04

/** EXERCISE 4.8] In this implementation, `map2` is only able to report one error, even if both the name
  *              and the age are invalid. What would you need to change in order to report both errors?
  *              Would you change `map2` or the signature of `mkPerson`? Or could you create a new data
  *              type that captures this requirement better than `Either` does, with some additional
  *              structure? How would `orElse`, `traverse`, and `sequence` behave differently for that
  *              data type?
  */
trait Es4_08 {

  case class Person(name: Name, age: Age)

  sealed class Name(val value: String)

  sealed class Age(val value: Int)

  def mkPerson(name: String, age: Int): Validation[List[String], List[Any]] = {
    mkName(name) +++ mkAge(age)
  }

  private def mkName(name: String): Validation[List[String], List[Any]] = {
    if (name == "" || name == null) {
      Failure(List("Name is empty."))
    } else {
      Success(List(name))
    }
  }

  private def mkAge(age: Int): Validation[List[String], List[Any]] = {
    if (age < 0) {
      Failure(List("Age is out of range."))
    } else {
      Success(List(age))
    }
  }
}
