package fpinscala.exercises.chapter03

import org.scalatest.FunSuite
import Es3_13._

class Es3_13Suite extends FunSuite {
  test("it should implement foldRight using foldLeft") {
    val xs = List(1, 2, 4, 7, 9, 11, 17)
    val res = foldRight[Int,String](xs, "Z")("(" + _ + " op " + _ + ")")
    assert(res == "(1 op (2 op (4 op (7 op (9 op (11 op (17 op Z)))))))")
  }

  test("it should implement foldLeft using foldRight") {
    val xs = List(1, 2, 4, 7, 9, 11, 17)
    val res = foldLeft(xs, "Z")("(" + _ + " op " + _ + ")")
    assert(res == "(((((((Z op 1) op 2) op 4) op 7) op 9) op 11) op 17)")
  }
}
