package fpinscala.exercises.chapter02

/**
 * EXERCISE 2.1] Write a recursive function to get the nth Fibonacci number (http://mng.bz/C29s).
 *               The first two Fibonacci numbers are 0 and 1 . The nth number is always the sum of the
 *               previous two—the sequence begins 0, 1, 1, 2, 3, 5 . Your definition should use a
 *               local tail-recursive function.
 */
object Es2_1 {

  def fib(n: Int): Int = n match {
    case 0 => 1
    case 1 => 1
    case _ => fib(n - 1) + fib(n - 2)
  }

  def fibIter(n: Int): Int = {
    require(n >= 0)

    @annotation.tailrec
    def loop(i: Int, fib: (Int, Int)): Int = {
      if (i == 0) {
        fib._1
      } else {
        val (f2, f1) = fib
        loop(i - 1, (f2 + f1, f2))
      }
    }
    loop(n, (1, 0))
  }

  // (lazy) stream with the fibonacci numbers (from ScalaDoc)
  val stream: Stream[Int] = 1 #:: 1 #:: stream.zip(stream.tail).map { n => n._1 + n._2}
}
