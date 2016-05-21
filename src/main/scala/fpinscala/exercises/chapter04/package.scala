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
package fpinscala.exercises

package object chapter04 {
  implicit def intAppend: Appendable[Int] = new Appendable[Int] {
    def append(a: Int, b: Int) = a + b
  }

  implicit def stringAppend: Appendable[String] = new Appendable[String] {
    def append(a: String, b: String) = a + b
  }

  implicit def seqAppend[A]: Appendable[List[A]] = new Appendable[List[A]] {
    def append(a: List[A], b: List[A]) = a ++ b
  }
}
