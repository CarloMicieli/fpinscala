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
package io.github.carlomicieli.fpinscala.chapter04

trait Es4_05 {
  def sequence[A](a: List[Option[A]]): Option[List[A]] = traverse(a)(x => x)

  def traverse[A, B](a: List[A])(f: A => Option[B]): Option[List[B]] = {
    val step = mapOpt(f) _
    a.foldRight(Option.just(List.empty[B]))(step)
  }

  private def mapOpt[A, B](f: A => Option[B])(x: A, acc: Option[List[B]]): Option[List[B]] = {
    (f(x), acc) match {
      case (None, _)           => None
      case (_, None)           => None
      case (Some(y), Some(ys)) => Some(y :: ys)
    }
  }
}
