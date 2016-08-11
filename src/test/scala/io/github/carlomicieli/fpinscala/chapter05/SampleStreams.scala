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

package io.github.carlomicieli.fpinscala.chapter05

trait SampleStreams {
  val emptyStream: Stream[Int] = Stream.empty[Int]
  def numbersStream: Stream[Int] = Stream(1, 2, 3, 4, 5, 6, 7)
  def stream: Stream[Int] = {
    import Stream._
    cons(1, cons(2, cons(throw new Exception, empty[Int])))
  }
}
