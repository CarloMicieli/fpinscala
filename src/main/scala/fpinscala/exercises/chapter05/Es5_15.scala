package fpinscala.exercises.chapter05

/**
 * EXERCISE 5.15] Implement tails using unfold. For a given Stream, tails returns the Stream of suffixes
 *                of the input sequence, starting with the original Stream. For example, given
 *                Stream(1,2,3), it would return Stream(Stream(1,2,3), Stream(2,3), Stream(3),
 *                Stream()).
 */
object Es5_15 {
  def tails[A]: Stream[Stream[A]] = ???
}
