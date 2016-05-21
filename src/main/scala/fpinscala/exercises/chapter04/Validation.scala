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

sealed trait Validation[+E, +A] {
  def +++[EE >: E, AA >: A](x: => Validation[EE, AA])(implicit
    ap1: Appendable[AA],
    ap2: Appendable[EE]): Validation[EE, AA] = (this, x) match {
    case (Failure(y), Failure(z)) => Failure(ap2.append(y, z))
    case (f1 @ Failure(y), _)     => f1
    case (_, f2 @ Failure(z))     => f2
    case (Success(y), Success(z)) => Success(ap1.append(y, z))
  }

  def isSuccess: Boolean
  def isFailure: Boolean = !isSuccess
}

case class Success[A](value: A) extends Validation[Nothing, A] {
  def isSuccess = true
}

case class Failure[E](value: E) extends Validation[E, Nothing] {
  def isSuccess = false
}

trait Appendable[A] {
  def append(a: A, b: A): A
}