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

sealed trait Option[+A] extends Product with Serializable {
  def isSome: Boolean
  def isNone: Boolean = !isSome

  def map[B](f: A => B): Option[B] = {
    this match {
      case Some(v) => Some(f(v))
      case None    => None
    }
  }

  def flatMap[B](f: A => Option[B]): Option[B] = {
    this match {
      case Some(v) => f(v)
      case None    => None
    }
  }

  def getOrElse[B >: A](default: => B): B = {
    this match {
      case Some(v) => v
      case None    => default
    }
  }

  def orElse[B >: A](ob: => Option[B]): Option[B] = {
    this match {
      case Some(_) => this
      case None    => ob
    }
  }

  def filter(f: A => Boolean): Option[A] = {
    this match {
      case Some(v) if f(v) => this
      case _               => None
    }
  }
}

object Option {
  def none[A]: Option[A] = None
  def some[A](x: A): Option[A] = Some(x)
}

final case class Some[+A](get: A) extends Option[A] {
  override def isSome: Boolean = true
}

case object None extends Option[Nothing] {
  override def isSome: Boolean = false
}