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

package io.github.carlomicieli.fpinscala.chapter07

import java.util.concurrent.TimeUnit._
import java.util.concurrent.{ Future, TimeUnit }

object TimeUnits {
  implicit class Long2TimeUnit(val n: Long) extends AnyVal {
    def millisecond: Timeout = Timeout(1, MILLISECONDS)
    def milliseconds: Timeout = Timeout(n, MILLISECONDS)
    def second: Timeout = Timeout(1, SECONDS)
    def seconds: Timeout = Timeout(n, SECONDS)
  }

  implicit class FutureWithTimeout[A](val f: Future[A]) extends AnyVal {
    def get(t: Timeout): A = f.get(t.timeout, t.unit)
  }

  case class Timeout(timeout: Long, unit: TimeUnit)
}
