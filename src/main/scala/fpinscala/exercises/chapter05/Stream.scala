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

sealed trait Stream[+A] {
  def isEmpty: Boolean

  def length: Int = this match {
    case Empty      => 0
    case Cons(_, t) => 1 + t().length
  }

  def headOption: Option[A] = this match {
    case Empty      => None
    case Cons(h, t) => Some(h())
  }

  def toList: List[A] = this match {
    case Empty => List.empty[A]
    case Cons(h, t) =>
      lazy val head = h()
      lazy val tail = t()
      head :: tail.toList
  }

  def take(n: Int): Stream[A] = (this, n) match {
    case (Empty, _)      => Empty
    case (_, 0)          => Empty
    case (Cons(h, t), i) => Cons(h, () => t().take(n - 1))
  }

  def takeWhile(p: A => Boolean): Stream[A] = this match {
    case Empty => Empty
    case (Cons(h, t)) =>
      lazy val head = h()
      if (p(head))
        Cons(() => head, () => t().takeWhile(p))
      else
        Empty
  }

  def drop(n: Int): Stream[A] = (this, n) match {
    case (Empty, _)      => Empty
    case (st, 0)         => st
    case (Cons(h, t), i) => t().drop(n - 1)
  }

  def find(p: A => Boolean): Option[A] =
    filter(p).headOption

  def filter(p: A => Boolean): Stream[A] = {
    this match {
      case Empty => Empty
      case Cons(h, t) =>
        lazy val head = h()
        if (p(head)) Stream.cons[A](head, t().filter(p)) else t().filter(p)
    }
  }

  def foldRight[B](z: => B)(f: (A, => B) => B): B = {
    this match {
      case Cons(h, t) => f(h(), t().foldRight(z)(f))
      case Empty      => z
    }
  }

  def map[B](f: A => B): Stream[B] =
    foldRight(Stream.empty[B])((a, b) => Stream.cons(f(a), b))

  def exists(p: A => Boolean): Boolean =
    foldRight(false)((a, b) => p(a) || b)

  def forAll(p: A => Boolean): Boolean =
    foldRight(true)((a, b) => p(a) && b)

  def append[B >: A](that: => Stream[B]): Stream[B] =
    foldRight(that)((a, b) => Stream.cons(a, b))

  def zip[B](that: Stream[B]): Stream[(A, B)] = (this, that) match {
    case (Empty, _)                   => Empty
    case (_, Empty)                   => Empty
    case (Cons(ah, at), Cons(bh, bt)) => Stream.cons((ah(), bh()), at() zip bt())
  }
}

object Empty extends Stream[Nothing] {
  val isEmpty = true
}
case class Cons[+A](h: () => A, t: () => Stream[A]) extends Stream[A] {
  var isEmpty = false
}

object Stream {
  def of[A](values: A*): Stream[A] =
    if (values.isEmpty) Stream.empty[A]
    else cons(values.head, Stream.of(values.tail: _*))

  def unfold[A, S](z: S)(f: S => Option[(A, S)]): Stream[A] = {
    f(z) match {
      case None         => Stream.empty[A]
      case Some((a, s)) => Stream.cons(a, unfold(s)(f))
    }
  }

  def cons[A](hd: => A, tl: => Stream[A]): Stream[A] = {
    lazy val head = hd
    lazy val tail = tl
    Cons(() => head, () => tail)
  }

  def range(lo: Int, hi: Int): Stream[Int] =
    if (lo >= hi) empty[Int]
    else cons(lo, range(lo + 1, hi))

  def empty[A]: Stream[A] = Empty

  def from(n: Int): Stream[Int] = cons(n, from(n + 1))

  def apply[A](as: A*): Stream[A] =
    if (as.isEmpty)
      empty
    else
      cons(as.head, apply(as.tail: _*))
}
