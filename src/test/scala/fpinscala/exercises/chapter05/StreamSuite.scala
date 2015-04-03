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

  test("it should take elements from a stream until they match a predicate") {
    val s1 = Stream.of(1, 2, 3, 4, 5)
    assert(s1.takeWhile(_ < 4).toList == List(1, 2, 3))

    val s2 = Stream.from(42)
    assert(s2.takeWhile(_ < 50).toList == (42 until 50).toList)
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

  test("it should look for an element in the stream") {
    val s1 = Stream.of(1, 2, 3, 4, 5)
    val s2 = Stream.from(42)

    assert(s1.find(_ == 4) == Some(4))
    assert(s1.find(_ == 99) == None)
    assert(s2.find(_ == 99) == Some(99))
  }

  test("it should append two streams together") {
    val s1 = Stream.of(1, 2, 3, 4)
    val s2 = Stream.from(5)
    assert(s1.append(s2).take(5).toList == (1 to 5).toList)
    assert(s2.append(s1).take(5).toList == (5 until 10).toList)
    assert(s2.append(s2).take(5).toList == (5 until 10).toList)
  }

  test("it should check whether all elements match a predicate") {
    val s = Stream.of(1, 2, 3, 4, 5)
    assert(s.forAll(_ < 10))
    assert(!s.forAll(_ % 2 == 0))

    assert(!Stream.from(10).forAll(_ < 5))
  }

  test("it should generate a stream using a function") {
    val f: Int => Option[(Int, Int)] = x => if (x < 5) Some((x * 2, x + 1)) else None
    assert(Stream.unfold(0)(f).toList == List(0, 2, 4, 6, 8))
  }

  test("it should zip corresponding elements in two streams") {
    val s1 = Stream.of(1, 2, 3)
    val s2 = Stream.from(10)

    val s = s1 zip s2
    assert(s.toList == List((1, 10), (2, 11), (3, 12)))
  }
}
