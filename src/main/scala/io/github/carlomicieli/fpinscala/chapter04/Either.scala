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

/**
  * Represents a value of one of two possible types (a disjoint union).
  * Instances of `Either` are either an instance of `Left` or `Right`.
  *
  * @tparam E
  * @tparam A
  */
sealed trait Either[+E, +A] extends Product with Serializable {

  def isRight: Boolean
  def isLeft: Boolean = !isRight

  def map[B](f: A => B): Either[E, B] = {
    this match {
      case Left(_)  => this.asInstanceOf[Either[E, B]]
      case Right(x) => Right(f(x))
    }
  }

  def flatMap[EE >: E, B](f: A => Either[EE, B]): Either[EE, B] = {
    this match {
      case Left(_)  => this.asInstanceOf[Either[EE, B]]
      case Right(x) => f(x)
    }
  }

  def orElse[EE >: E, B >: A](b: => Either[EE, B]): Either[EE, B] = {
    this match {
      case Right(_) => this
      case Left(_)  => b
    }
  }

  def map2[EE >: E, B, C](b: Either[EE, B])(f: (A, B) => C): Either[EE, C] = {
    for {
      x <- this
      y <- b
    } yield f(x, y)
  }
}

object Either {
  def left[E](x: E): Either[E, Nothing] = Left(x)
  def right[A](x: A): Either[Nothing, A] = Right(x)
}

final case class Left[+E](value: E) extends Either[E, Nothing] {
  def isRight: Boolean = false
}

final case class Right[+A](value: A) extends Either[Nothing, A] {
  def isRight: Boolean = true
}
