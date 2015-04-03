package fpinscala.exercises.chapter05

import org.scalatest.FunSuite
import Es5_14._

class Es5_14Suite extends FunSuite {
  test("it should check whether a stream is prefix of the second") {
    val s1 = Stream.from(1)
    val s2 = Stream.of(1, 2, 3)
    val s3 = Stream.from(42)

    assert(startsWith(s1, s2))
    assert(!startsWith(s2, s3))
    assert(!startsWith(s1, s3))
  }
}
