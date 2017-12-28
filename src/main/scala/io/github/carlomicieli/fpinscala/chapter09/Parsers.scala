/*
 * Copyright 2017 Carlo Micieli
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

package io.github.carlomicieli
package fpinscala
package chapter09

import scala.util.matching.Regex

trait Parsers[ParseError, Parser[+_]] { self =>

  /** Chooses between two parsers, first attempting p1 , and then p2 if p1 fails.
    */
  def or[A](p1: Parser[A], p2: => Parser[A]): Parser[A]

  /** Returns the portion of input inspected by p if successful.
    */
  def slice[A](p: Parser[A]): Parser[String]

  /** Sequences two parsers, running p1 and then p2, and returns
    * the pair of their results if both succeed.
    */
  def product[A, B](p: Parser[A], p2: => Parser[B]): Parser[(A, B)] = {
    for {
      x <- p
      y <- p2
    } yield (x, y)
  }

  def run[A](p: Parser[A])(input: String): Either[ParseError, A]

  /** Applies the function f to the result of p , if successful
    */
  def map[A, B](p: Parser[A])(f: A => B): Parser[B] = {
    flatMap(p)(a => succeed(f(a)))
  }

  def flatMap[A, B](p: Parser[A])(f: A => Parser[B]): Parser[B]

  def char(c: Char): Parser[Char] = {
    string(c.toString).map(_.charAt(0))
  }

  def listOfN[A](n: Int, p: Parser[A]): Parser[List[A]] = {
    if (n <= 0) {
      succeed(List.empty[A])
    } else {
      map2(p, listOfN(n - 1, p))(_ :: _)
    }
  }

  /** The parser recognizes zero or more repetitions
    */
  def many[A](p: Parser[A]): Parser[List[A]] = {
    map2(p, many(p))(_ :: _) or succeed(List.empty[A])
  }

  /** The parser recognizes one or more repetitions
    */
  def many1[A](p: Parser[A]): Parser[List[A]] = {
    product(p, many(p)).map(r => r._1 :: r._2)
  }

  /** This parser always succeeds with the value a, regardless of the input string
    */
  def succeed[A](a: A): Parser[A] = {
    string("").map(_ => a)
  }

  def map2[A, B, C](p: Parser[A], p2: => Parser[B])(f: (A, B) => C): Parser[C] = {
    for {
      x <- p
      y <- p2
    } yield f(x, y)
  }

  implicit def regex(r: Regex): Parser[String]
  implicit def string(s: String): Parser[String]
  implicit def operators[A](p: Parser[A]): ParserOps[A] = ParserOps[A](p)
  implicit def asStringParser[A](a: A)(implicit f: A => Parser[String]): ParserOps[String] = ParserOps(f(a))

  case class ParserOps[A](p: Parser[A]) {
    def |[B >: A](p2: Parser[B]): Parser[B] = or(p2)
    def or[B >: A](p2: => Parser[B]): Parser[B] = self.or(p, p2)

    def product[B >: A](p2: Parser[B]): Parser[(A, B)] = self.product(p, p2)
    def **[B >: A](p2: Parser[B]): Parser[(A, B)] = product(p2)

    def many[B >: A]: Parser[List[B]] = self.many(p)

    def map[C](f: A => C): Parser[C] = self.map(p)(f)
    def flatMap[C](f: A => Parser[C]): Parser[C] = self.flatMap(p)(f)

    def slice: Parser[String] = self.slice(p)
  }

  object Laws {
    def equals[A](p1: Parser[A], p2: Parser[A])(in: String): Boolean = {
      run(p1)(in) == run(p2)(in)
    }

    def mapLaw[A](p: Parser[A])(in: String): Boolean = {
      equals(p, p.map(a => a))(in)
    }

    def stringLaw[A](s: String): Boolean = {
      run(string(s))(s) == Right(s)
    }

    def charLaw[A](c: Char): Boolean = {
      run(char(c))(c.toString) == Right(c)
    }

    def orLaws[A](p: Parser[A])(s1: String, s2: String): Boolean = {
      run(or(string(s1), string(s1)))(s1) == Right(s1)
      run(or(string(s1), string(s1)))(s2) == Right(s2)
    }

    def succeedLaw[A](a: A)(in: String): Boolean = {
      run(succeed(a))(in) == Right(a)
    }
  }
}
