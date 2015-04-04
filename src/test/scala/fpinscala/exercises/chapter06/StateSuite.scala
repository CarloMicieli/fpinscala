package fpinscala.exercises.chapter06

import org.scalatest.FunSuite
import State._

class StateSuite extends FunSuite {
  test("it should create the unit state") {
    val (a, _) = unit(42)("one")
    assert(a == 42)

    val (b, _) = unit(42)("two")
    assert(b == 42)
  }

  test("it should map a state value with a function") {
    val state: State[String, Int] = unit(42)
    val (a, _) = map(state)(_ * 2)("")
    assert(a == 84)
  }

  test("it should map two states") {
    val s1: State[String, Int] = unit(21)
    val s2: State[String, Int] = unit(21)

    val (a, _) = map2(s1, s2)(_ + _)("run")
    assert(a == 42)
  }

  test("it should produce a sequence of state") {
    val ls: List[State[String, Int]] = List.fill(5)(unit(1))
    val (out, _) = sequence(ls)("")
    assert(out == List(1, 1, 1, 1, 1))
  }
}
