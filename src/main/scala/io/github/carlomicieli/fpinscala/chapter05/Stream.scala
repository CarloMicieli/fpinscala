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

package io.github.carlomicieli.fpinscala.chapter05
import Stream._

/** A lazy list.
  * @tparam A the element type
  */
sealed trait Stream[+A] {

  def isEmpty: Boolean = {
    this match {
      case Cons(_, _) => false
      case _          => true
    }
  }

  def headOption: Option[A] = {
    this match {
      case Cons(h, _) => Some(h())
      case _          => None
    }
  }

  def tail: Stream[A] = {
    this match {
      case Cons(_, t) => t()
      case _          => empty[A]
    }
  }

  @annotation.tailrec
  final def exists(p: A => Boolean): Boolean = {
    this match {
      case Cons(h, t) => p(h()) || t().exists(p)
      case _          => false
    }
  }

  def length: Int = {
    this match {
      case Cons(_, tail) => 1 + tail().length
      case Empty         => 0
    }
  }

  def foreach[U](f: A => U): Unit = {
    foldRight(())((a, b) => {
      val _ = f(a)
      b
    })
  }

  @annotation.tailrec
  final def foldLeft[B](z: => B)(op: (=> B, A) ⇒ B): B = {
    this match {
      case Cons(h, t) => t().foldLeft(op(z, h()))(op)
      case Empty      => z
    }
  }

  @annotation.tailrec
  final def foldLeftStrict[B](z: B)(op: (B, A) ⇒ B): B = {
    this match {
      case Cons(h, t) => t().foldLeftStrict(op(z, h()))(op)
      case Empty      => z
    }
  }

  def foldRight[B](z: => B)(f: (A, => B) => B): B = {
    this match {
      case Cons(h, t) => f(h(), t().foldRight(z)(f))
      case Empty      => z
    }
  }

  def drop(n: Int): Stream[A] = {
    this match {
      case Cons(_, t) if n > 0 => t().drop(n - 1)
      case _                   => this
    }
  }

  def take(n: Int): Stream[A] = {
    this match {
      case Cons(h, t) if n > 0 => cons(h(), t().take(n - 1))
      case _                   => empty[A]
    }
  }

  def append[A1 >: A](that: Stream[A1]): Stream[A1] = {
    this match {
      case Cons(h, t) => Stream.cons(h(), t().append(that))
      case Empty      => that
    }
  }
}

case object Empty extends Stream[Nothing] {
  override def equals(o: Any): Boolean = {
    o match {
      case _: Empty.type => true
      case _             => false
    }
  }
}

final case class Cons[A] private (h: () => A, t: () => Stream[A]) extends Stream[A] {
  override def equals(o: Any): Boolean = {
    o match {
      case _: Empty.type   => false
      case that: Stream[_] => Cons.sameStream(this, that)
      case _               => false
    }
  }
}

object Cons {
  @annotation.tailrec
  private def sameStream(s1: Stream[_], s2: Stream[_]): Boolean = {
    (s1, s2) match {
      case (Cons(h1, t1), Cons(h2, t2)) if h1() == h2() => sameStream(t1(), t2())
      case (Empty, Empty) => true
      case _ => false
    }
  }
}

object Stream {
  def cons[A](hd: => A, tl: => Stream[A]): Stream[A] = {
    lazy val head = hd
    lazy val tail = tl
    Cons(() => head, () => tail)
  }

  def empty[A]: Stream[A] = Empty

  def apply[A](a1: => A): Stream[A] = {
    cons(a1, empty[A])
  }

  def apply[A](a1: => A, a2: => A): Stream[A] = {
    cons(a1, cons(a2, empty[A]))
  }

  def apply[A](a1: => A, a2: => A, a3: => A): Stream[A] = {
    cons(a1, cons(a2, cons(a3, empty[A])))
  }

  def apply[A](a1: => A, a2: => A, a3: => A, a4: => A): Stream[A] = {
    cons(a1, cons(a2, cons(a3, cons(a4, empty[A]))))
  }

  def apply[A](a1: => A, a2: => A, a3: => A, a4: => A, a5: => A): Stream[A] = {
    cons(a1, cons(a2, cons(a3, cons(a4, cons(a5, empty[A])))))
  }

  def enumFrom[A](a0: A)(f: A => A): Stream[A] = {
    cons(a0, enumFrom(f(a0))(f))
  }

  val positiveNumbers: Stream[Int] = enumFrom(1)(_ + 1)

  def fromRange(r: Range): Stream[Int] = {
    r.foldRight(Stream.empty[Int])((x, xs) => Stream.cons(x, xs))
  }

  def from(start: Int): Stream[Int] = enumFrom(start)(_ + 1)

  def fromValues[A](items: A*): Stream[A] = {
    items.foldRight(Stream.empty[A])((x, xs) => Stream.cons(x, xs))
  }
}