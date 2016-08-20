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

package io.github.carlomicieli.fpinscala.chapter07

import java.util.concurrent.{ Callable, TimeUnit, ExecutorService, Future }

object Par {
  type Par[A] = ExecutorService => Future[A]

  private case class UnitFuture[A](get: A) extends Future[A] {
    def isCancelled: Boolean = false
    def get(timeout: Long, unit: TimeUnit): A = get
    def cancel(mayInterruptIfRunning: Boolean): Boolean = false
    def isDone: Boolean = true
  }

  def unit[A](a: A): Par[A] = (es: ExecutorService) => UnitFuture(a)
  def lazyUnit[A](a: => A): Par[A] = fork(unit(a))
  def run[A](s: ExecutorService)(a: Par[A]): Future[A] = a(s)
  def fork[A](a: => Par[A]): Par[A] =
    (es: ExecutorService) => es.submit(new Callable[A] {
      def call(): A = a(es).get
    })

  def map2[A, B, C](a: Par[A], b: Par[B])(f: (A, B) => C): Par[C] = {
    (es: ExecutorService) =>
      {
        val fa = a(es)
        val fb = b(es)
        UnitFuture(f(fa.get, fb.get))
      }
  }

  def asyncF[A, B](f: A => B): A => Par[B] = a => lazyUnit(f(a))

  def sequence[A](ps: List[Par[A]]): Par[List[A]] =
    ps.foldLeft(unit(List.empty[A]))((as, a) => map2(a, as)(_ :: _))

  def parMap[A, B](ps: List[A])(f: A => B): Par[List[B]] = fork {
    val pars: List[Par[B]] = ps.map(asyncF(f))
    sequence(pars)
  }

  def sum(seq: IndexedSeq[Int]): Par[Int] = {
    if (seq.size <= 1)
      unit(seq.headOption getOrElse 0)
    else {
      val (l, r) = seq.splitAt(seq.length / 2)
      val lSum = sum(l)
      val rSum = sum(r)
      Par.map2(Par.fork(lSum), Par.fork(rSum))(_ + _)
    }
  }
}
