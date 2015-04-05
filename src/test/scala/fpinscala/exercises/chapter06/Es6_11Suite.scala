package fpinscala.exercises.chapter06

import org.scalatest.FunSuite
import Es6_11._

class Es6_11Suite extends FunSuite {
  test("it should simulate a candy machine") {
    val mch = Machine(true, 5, 10)
    val inputs = List(Coin, Turn, Coin, Turn, Coin, Turn, Coin, Turn)

    val (a, mch2) = simulateMachine(inputs)(mch)

    assert(a == (14, 1))
    assert(mch2.candies == 1)
    assert(mch2.coins == 14)
  }

  test("it should do nothing if there is no candies") {
    val mch = Machine(true, 0, 10)
    val inputs = List(Coin, Turn)

    val (a, mch2) = simulateMachine(inputs)(mch)
    assert(a == (10, 0))
    assert(mch == mch2)
  }

  test("it should do nothing if the machine is already unlocked") {
    val mch = Machine(false, 0, 10)
    val inputs = List(Turn)

    val (_, mch2) = simulateMachine(inputs)(mch)
    assert(mch == mch2)
  }
}
