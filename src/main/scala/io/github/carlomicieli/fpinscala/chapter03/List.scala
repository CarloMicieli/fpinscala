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
package io.github.carlomicieli.fpinscala.chapter03

import io.github.carlomicieli.fpinscala._

/**
  * An immutable linked list. The list is either a constructed list or the empty list.
  * @tparam A
  */
sealed trait List[+A] extends Product with Serializable {
  /**
    * Selects the first element of this list.
    * @return
    */
  def head: A

  /**
    * Selects all elements except the first.
    * @return
    */
  def tail: List[A]

  /**
    * Checks whether this list is empty.
    * @return
    */
  def isEmpty: Boolean

  def apply(ind: Int): Option[A] = {
    @annotation.tailrec
    def loop(i: Int, xs: List[A]): Option[A] = {
      (i, xs) match {
        case (0, Cons(h, _)) => Some(h)
        case (n, Cons(_, t)) => loop(n - 1, t)
        case (_, Nil)        => None
      }
    }

    loop(ind, this)
  }

  def length: Long = {
    foldLeft(0L)((out, x) => out + 1)
  }

  def foreach[U](f: A => U): Unit = {
    this match {
      case Nil => ()
      case Cons(x, xs) =>
        val ignored = f(x)
        xs foreach f
    }
  }

  def foldRight[B](z: B)(op: (A, B) => B): B = {
    val step: (B, A) => B = (b, a) => op(a, b)
    reverse.foldLeft(z)(step)
  }

  def foldLeft[B](z: B)(op: (B, A) => B): B = {
    @annotation.tailrec
    def loop(xs: List[A], acc: B): B = {
      xs match {
        case Nil         => acc
        case Cons(y, ys) => loop(ys, op(acc, y))
      }
    }

    loop(this, z)
  }

  def flatMap[B](f: A => List[B]): List[B] = {
    foldRight(List.empty[B])((x, xs) => f(x) append xs)
  }

  def reverse: List[A] = {
    foldLeft(List.empty[A])((xs, x) => Cons(x, xs))
  }

  def append[A1 >: A](that: List[A1]): List[A1] = {
    foldRight(that)((x, xs) => Cons(x, xs))
  }

  override def toString: String = {
    def print(xs: List[A]): String = {
      xs match {
        case Nil          => ""
        case Cons(y, Nil) => s"$y"
        case Cons(y, ys)  => s"$y, ${print(ys)}"
      }
    }
    s"[${print(this)}]"
  }
}

object List {

  def fill[A](n: Int)(x: A): List[A] = {
    (1 to n).foldRight(List.empty[A])((_, xs) => Cons(x, xs))
  }

  def empty[A]: List[A] = Nil

  def apply[A](items: A*): List[A] = {
    items match {
      case h +: t => Cons(h, List.apply(t: _*))
      case _      => List.empty[A]
    }
  }

  def unapply[A](l: List[A]): Option[(A, List[A])] = {
    if (l.isEmpty) {
      None
    } else {
      Some((l.head, l.tail))
    }
  }
}

case object Nil extends List[Nothing] {
  def head: Nothing = error("Nil.head")
  def tail: Nothing = error("Nil.tail")
  def isEmpty: Boolean = true
}

final case class Cons[A](head: A, tail: List[A]) extends List[A] {
  def isEmpty: Boolean = false
}