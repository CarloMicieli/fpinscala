package fpinscala.exercises.chapter04

import org.scalatest.{Matchers, FunSuite}
import Es4_03._

class Es4_03Suite extends FunSuite with Matchers {
  test("it should map over two Option values") {
    val some1 = Some(40)
    val some2 = Some(2)
    val none = None

    val f: (Int, Int) => Int = _ + _

    map2(some1, some2)(f) should be(Some(42))
    map2(some1, none)(f) should be(None)
    map2(none, some2)(f) should be(None)
    map2V2(some1, some2)(f) should be(Some(42))
    map2V2(none, some2)(f) should be(None)
  }
}
