package fpinscala.samples.chapter02

object Factorial {

  def fact1(n: Int): BigInt = n match {
    case 0 => 1
    case _ => n * fact1(n - 1)
  }

  def fact2(n: Int): BigInt = {
    @annotation.tailrec
    def loop(i: Int, acc: BigInt): BigInt = {
      if (i <= 1) acc
      else loop(i - 1, i * acc)
    }

    loop(n, 1)
  }

  def fact3(n: Int): BigInt = (1 to n).product

  def fact4(n: Int): BigInt = {
    var fact: BigInt = 1
    var i = 1

    while (i <= n) {
      fact = fact * i
      i = i + 1
    }

    fact
  }

  // (lazy) stream for factorials
  val stream: Stream[BigInt] = {
    def loop(n: Int, prev: BigInt): Stream[BigInt] = {
      val fact = n * prev
      fact #:: loop(n + 1, fact)
    }
    loop(1, 1)
  }
}

// Binomial coefficient
//  http://en.wikipedia.org/wiki/Combination
object BinCoefficient {

  implicit class IntFact(val n: Int) extends AnyVal {
    def ! = Factorial.fact2(n)
  }

  import scala.language.postfixOps

  def apply(n: Int, k: Int): BigInt = {
    (n !) / ((k !) * ((n - k) !))
  }
}
