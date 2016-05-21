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

import org.scalatest.FunSuite

class ListSuite extends FunSuite {
  test("it should return the head and tail of a list") {
    val l = 1 :: Nil
    assert(l.head == 1)
    assert(l.tail == Nil)
  }

  test("it should throw an exception asking for the empty list head") {
    val thrown = intercept[NoSuchElementException] {
      Nil.head
    }
  }

  test("it should throw an exception asking for the empty list tail") {
    val thrown = intercept[NoSuchElementException] {
      Nil.tail
    }
  }

  test("it should check whether a list is empty") {
    assert(Nil.isEmpty)
    assert(!List(1, 2).isEmpty)
  }

  test("it should produce string representation for lists") {
    assert(Nil.toString == "[]")
    assert(List(1, 2, 3).toString == "[1, 2, 3]")
  }

  test("it should construct lists with cons") {
    val l = 1 :: 2 :: 3 :: 4 :: Nil
    assert(l == List(1, 2, 3, 4))
  }

  test("it should map a function to all list elements") {
    val l = List(2, 3, 4, 5, 6, 7)
    assert(l.map(_ * 2) == List(4, 6, 8, 10, 12, 14))
    assert(List.empty[Int].map(_ * 2) == Nil)
  }

  test("it should map a function to all list elements and then flatten the result") {
    val l = List("hello", "world")
    assert(l.flatMap(s => List(s, s.toUpperCase)) == List("hello", "HELLO", "world", "WORLD"))
    assert(List.empty[Int].flatMap(x => List(x)) == Nil)
  }

  test("it should reverse a list") {
    val l = List(1, 2, 3, 4)
    assert(l.reverse == List(4, 3, 2, 1))
    assert(Nil.reverse == Nil)
  }

  test("it should append a second list") {
    val l1 = List(1, 2)
    val l2 = List(3, 4)
    assert(l1 ++ l2 == List(1, 2, 3, 4))
    assert(Nil ++ l2 == l2)
    assert(l1 ++ Nil == l1)
  }

  test("folding a list yields the same result if the operation is associative") {
    val l = List(1, 2, 3, 4)
    assert(l.foldLeft(0)(_ + _) == 10)
    assert(l.foldRight(0)(_ + _) == 10)

    assert(l.foldLeft(0)(_ - _) == -10)
    assert(l.foldRight(0)(_ - _) == -2)
  }

  test("foreach should run for the function side-effect only") {
    val l = List(1, 2, 3, 4)
    var sum = 0
    l.foreach(x => sum = sum + x)
    assert(sum == 10)
  }

  test("length should return the number of elements in the list") {
    assert(Nil.length == 0)
    assert(List(1, 2, 4, 5).length == 4)
  }

  test("it should flatten a list of lists") {
    val list = List(List(1, 2), List(3), List(4, 5))
    assert(list.flatten == List(1, 2, 3, 4, 5))
  }
}
