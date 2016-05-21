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
package fpinscala.exercises.chapter05

/**
  * EXERCISE 5.3] Write the function `takeWhile` for returning all starting elements of a `Stream` that
  *               match the given predicate.
  */
object Es5_03 {

  def takeElementsWhile(): List[Int] = {
    numbersStream.take(5).toList
  }

  def numbersStream: Stream[Int] = Stream.from(1)

}
