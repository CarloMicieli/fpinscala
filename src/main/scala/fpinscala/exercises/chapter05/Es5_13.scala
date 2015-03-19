package fpinscala.exercises.chapter05

/**
 * EXERCISE 5.13] Use unfold to implement map, take, takeWhile, zipWith (as in chapter 3), and
 *                zipAll. The zipAll function should continue the traversal as long as either stream
 *                has more elements—it uses Option to indicate whether each stream has been
 *                exhausted.
 */
object Es5_13 {
  def zipAll[A,B](s2: Stream[B]): Stream[(Option[A],Option[B])] = ???
}
