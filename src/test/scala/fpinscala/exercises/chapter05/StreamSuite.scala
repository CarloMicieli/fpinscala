package fpinscala.exercises.chapter05

import org.scalatest.FunSuite

class StreamSuite extends FunSuite {
  test("it should produce a stream from a list of values") {
    val s = Stream.of(1, 2, 3, 4)
    assert(s.toList == List(1, 2, 3, 4))
  }

  test("it should produce a range stream") {
    val r1 = Stream.range(40, 45)
    assert(r1.toList == List(40, 41, 42, 43, 44))

    val r2 = Stream.range(1, 1000).take(3).toList
    assert(r2.toList == List(1, 2, 3))
  }

  test("it should filter elements in the stream") {
    val r = Stream.range(1, 10).filter(_ % 2 == 0)
    assert(r.toList == List(2, 4, 6, 8))
  }

  test("it should apply operations to infinite streams") {
    val s = Stream.from(1).filter(_ % 3 == 0).take(4)
    assert(s.toList == List(3, 6, 9, 12))
  }

  test("it should compute a (finite) stream length") {
    val s = Stream.from(1).take(10)
    assert(s.length == 10)
  }

  test("it should fold a (finite) stream") {
    val s = Stream.of(1, 2, 3, 4, 5)
    assert(s.foldRight(0)(_ + _) == 15)
  }

  test("it should check whether a stream contains one element that matches the predicate") {
    val s = Stream.of(1, 2, 3, 4, 5)
    assert(s.exists(_ == 4))
    assert(!s.exists(_ > 99))

    assert(Stream.from(1).exists(_ > 100))
  }

  test("forAll") {
    val s = Stream.of(1, 2, 3, 4, 5)
    assert(s.forAll(_ < 10))
    assert(!s.forAll(_ % 2 == 0))

    assert(!Stream.from(10).forAll(_ < 5))
  }
}
