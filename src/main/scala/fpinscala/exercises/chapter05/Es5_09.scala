package fpinscala.exercises.chapter05

/**
 * EXERCISE 5.9] Write a function that generates an infinite stream of integers, starting from n, then
 *               n + 1, n + 2, and so on.
 */
object Es5_09 {
  def from(n: Int): Stream[Int] = Stream.cons(n, from(n + 1))
}
