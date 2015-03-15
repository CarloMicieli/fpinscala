package fpinscala.samples.chapter02

// WARNING: Long return types will likely cause overflow computing sums
//          The purpose of this code is to test stack overflow errors and
//          tail call optimization.
//          Unable to keep this code under test as sum2 is slow, and extremely
//          slow using BigInt.
object StackOverflow {

  // sum from math (Gauss formula)
  def sum(n: Int): Long = n * (n + 1) / 2

  // recursive sum of integer from 0 to n
  def sum1(n: Int): Long = n match {
    case 0 => 0
    case _ => n + sum1(n - 1)
  }

  //tail optimized recursive sum of integer from 0 to n
  def sum2(n: Int): Long = {
    @annotation.tailrec
    def loop(i: Int, acc: Long): Long = i match {
      case 0 => acc
      case _ => loop(i + 1, i + acc)
    }

    loop(n, 0)
  }
}