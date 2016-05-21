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
package fpinscala.exercises.chapter03

/**
  * EXERCISE 3.13] Can you write `foldLeft` in terms of `foldRight`? How about the other way
  *                around? Implementing `foldRight` via `foldLeft` is useful because it lets us
  *                implement `foldRight` tail-recursively, which means it works even for large
  *                lists without overflowing the stack.
  */
object Es3_13 {
  def foldRight[A, B](list: List[A], z: B)(f: (A, B) => B): B = {
    list.reverse.foldLeft(z)((xs, x) => f(x, xs))
  }

  def foldLeft[A, B](list: List[A], z: B)(f: (B, A) => B): B = {
    list.reverse.foldRight(z)((x, xs) => f(xs, x))
  }
}
