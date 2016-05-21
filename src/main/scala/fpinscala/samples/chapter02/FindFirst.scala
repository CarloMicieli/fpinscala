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
package fpinscala.samples.chapter02

object FindFirst {
  def apply[A](array: Array[A])(p: A => Boolean): Option[Int] = {
    @annotation.tailrec
    def loop(i: Int): Option[Int] = {
      if (i == array.size) None
      else {
        if (p(array(i)))
          Some(i)
        else
          loop(i + 1)
      }
    }

    loop(0)
  }
}
