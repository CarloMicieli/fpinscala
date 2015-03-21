package fpinscala.exercises.chapter03

/**
 * EXERCISE 3.3] Using the same idea, implement the function `setHead` for replacing the
 *               first element of a `List` with a different value.
 */
object Es3_03 {
  def setHead[A](newHead: A, list: List[A]): List[A] = list match {
    case x :: xs => newHead :: xs
    case Nil => Nil
  }
}
