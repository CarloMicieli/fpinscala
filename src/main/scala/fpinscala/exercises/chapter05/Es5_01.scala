package fpinscala.exercises.chapter05

/**
 * EXERCISE 5.1] Write a function to convert a `Stream` to a `List`, which will force its evaluation and let
 *               you look at it in the Repl. You can convert to the regular `List` type in the standard
 *               library. You can place this and other functions that operate on a `Stream` inside the
 *               Stream trait.
 */
object Es5_01 {
  def streamToList(): List[Int] = {
    Stream(1,2,3).toList
  }
}
