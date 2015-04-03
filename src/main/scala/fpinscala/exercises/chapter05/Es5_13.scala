package fpinscala.exercises.chapter05

/**
 * EXERCISE 5.13] Use `unfold` to implement `map`, `take`, `takeWhile`, `zipWith` (as in chapter 3), and
 *                `zipAll`. The `zipAll` function should continue the traversal as long as either stream
 *                has more elements—it uses `Option` to indicate whether each stream has been
 *                exhausted.
 */
object Es5_13 {
  def map[A, B](st: Stream[A])(f: A => B): Stream[B] = ???

  def take[A](st: Stream[A])(n: Int): Stream[A] = ???

  def takeWhile[A](st: Stream[A])(p: A => Boolean): Stream[A] = ???

  def zipWith[A, B](as: Stream[A], bs: Stream[A])(f: (A, A) => B): Stream[B] = ???

  def zipAll[A, B](s2: Stream[B]): Stream[(Option[A], Option[B])] = ???
}
