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

import Es4_03._

/**
  * EXERCISE 4.4] Write a function sequence that combines a list of `Option`s into one
  *               `Option` containing a list of all the `Some` values in the original list.
  *               If the original list contains `None` even once, the result of the function
  *               should be `None`; otherwise the result should be `Some` with a list of
  *               all the values.
  */
object Es4_04 {
  def sequence[A](a: List[Option[A]]): Option[List[A]] = {
    @annotation.tailrec
    def loop(list: List[Option[A]], acc: List[A]): Option[List[A]] = list match {
      case Some(x) :: xs => loop(xs, x :: acc)
      case None :: _     => None
      case Nil           => Some(acc.reverse)
    }

    loop(a, List.empty[A])
  }

  def sequenceV2[A](a: List[Option[A]]): Option[List[A]] = {
    val step = (x: Option[A], xs: Option[List[A]]) => map2(x, xs)(_ :: _)
    a.foldRight(Option(List.empty[A]))(step)
  }
}
