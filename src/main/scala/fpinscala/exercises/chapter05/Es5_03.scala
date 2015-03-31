package fpinscala.exercises.chapter05

/**
 * EXERCISE 5.3] Write the function `takeWhile` for returning all starting elements of a `Stream` that
 *               match the given predicate.
 */
object Es5_03 {

  def takeElementsWhile(): List[Int] = {
    numbersStream.take(5).toList
  }

  def numbersStream: Stream[Int] = Stream.from(1)

}
