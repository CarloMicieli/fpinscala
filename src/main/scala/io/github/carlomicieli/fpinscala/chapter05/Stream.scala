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
package io.github.carlomicieli.fpinscala.chapter05

trait Stream[+A] {
  def length: Int = {
    this match {
      case Cons(_, tail) => 1 + tail().length
      case Empty         => 0
    }
  }

  def toList: List[A] = {
    this match {
      case Cons(h, t) => h() :: t().toList
      case Empty      => List.empty[A]
    }
  }

  def foreach[U](f: A => U): Unit = {
    foldRight(())((a, _) => { val d = f(a); () })
  }

  def foldRight[B](z: => B)(f: (A, => B) => B): B = {
    this match {
      case Cons(h, t) => f(h(), t().foldRight(z)(f))
      case Empty      => z
    }
  }
}
case object Empty extends Stream[Nothing]
case class Cons[A] private (h: () => A, t: () => Stream[A]) extends Stream[A]

object Stream {
  def cons[A](hd: => A, tl: => Stream[A]): Stream[A] = {
    lazy val head = hd
    lazy val tail = tl
    Cons(() => head, () => tail)
  }

  def empty[A]: Stream[A] = Empty

  def apply[A](items: A*): Stream[A] = {
    items.foldRight(empty[A])((a, b) => Stream.cons(a, b))
  }
}