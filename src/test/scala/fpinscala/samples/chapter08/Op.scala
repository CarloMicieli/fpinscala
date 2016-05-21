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
package fpinscala.samples.chapter08

sealed trait Op
case class Insert(v: Int) extends Op
case object DeleteMin extends Op

object Ops {
  def toHeap(xs: List[Op]): SkewHeap[Int] = {
    val step = (heap: SkewHeap[Int], op: Op) => (heap, op) match {
      case (Empty, DeleteMin) => Empty
      case (h, Insert(x))     => h.insert(x)
      case (h, DeleteMin)     => h.deleteMin
    }
    xs.foldLeft(SkewHeap.empty[Int])(step)
  }
}