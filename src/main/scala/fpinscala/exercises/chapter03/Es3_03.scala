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

/**
  * EXERCISE 3.3] Using the same idea, implement the function `setHead` for replacing the
  *               first element of a `List` with a different value.
  */
object Es3_03 {
  def setHead[A](newHead: A, list: List[A]): List[A] = list match {
    case x Cons xs => newHead :: xs
    case Nil       => Nil
  }
}
