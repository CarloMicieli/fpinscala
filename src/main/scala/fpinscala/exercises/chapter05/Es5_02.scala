package fpinscala.exercises.chapter05

/**
 * EXERCISE 5.2] Write the function take(n) for returning the first n elements of a Stream, and
 *               drop(n) for skipping the first n elements of a Stream.
 */
object Es5_02 {

  def takeFromStream[A](s: Stream[A], n: Int): List[A] = {
    s.take(n).toList
  }

  def dropFromStream[A](s: Stream[A], n: Int): List[A] = {
    s.drop(n).toList
  }

}
