package fpinscala.exercises.chapter05

import org.scalatest.FunSuite
import Es5_13._

class Es5_13Suite extends FunSuite {
  test("it should implement map in terms of unfold") {
    val s = Stream.range(1, 5)
    assert(map(s)(_ * 2).toList == List(2, 4, 6, 8))
    assert(map(Stream.from(1))(_ * 2).take(4).toList == List(2, 4, 6, 8))
  }

  test("it should implement take in terms of unfold") {
    val s = Stream.range(1, 5)
    assert(take(s)(3).toList == List(1, 2, 3))
    assert(take(Stream.from(1))(3).toList == List(1, 2, 3))
  }

  test("it should implement takeWhile in terms of unfold") {
    val s = Stream.range(1, 5)
    assert(takeWhile(s)(_ < 4).toList == List(1, 2, 3))
    assert(takeWhile(Stream.from(1))(_ < 4).toList == List(1, 2, 3))
  }

  test("it should implement zipWith in terms of unfold") {
    val s1 = Stream.range(1, 5)
    val s2 = Stream.range(1, 5)
    assert(zipWith(s1, s2)(_ * _).toList == List(1, 4, 9, 16))
    assert(zipWith(s1, Stream.from(1))(_ * _).toList == List(1, 4, 9, 16))
  }

  test("it should zipAll elements for two streams") {
    val s1 = Stream.of(1, 2)
    val s2 = Stream.of(1, 2, 3)
    assert(zipAll(s1, s2).toList == List((Some(1), Some(1)), (Some(2), Some(2)), (None, Some(3))))
    assert(zipAll(s2, s1).toList == List((Some(1), Some(1)), (Some(2), Some(2)), (Some(3), None)))

    val s3 = Stream.from(42)
    val s4 = Stream.of(1)
    assert(zipAll(s3, s4).take(3).toList == List((Some(42),Some(1)), (Some(43),None), (Some(44),None)))
  }
}
