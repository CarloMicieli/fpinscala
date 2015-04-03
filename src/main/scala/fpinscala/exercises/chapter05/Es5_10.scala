package fpinscala.exercises.chapter05

/**
 * EXERCISE 5.10] Write a function fibs that generates the infinite stream of Fibonacci numbers:
*                 0, 1, 1, 2, 3, 5, 8, and so on.
 */
object Es5_10 {
  def fibs: Stream[Int] = Stream.of(0, 1).append(nextFib(0, 1))

  private def nextFib(n1: Int, n2: Int): Stream[Int] = {
    val next = n1 + n2
    Stream.cons(next, nextFib(n2, next))
  }
}
