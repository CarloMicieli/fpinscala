package fpinscala.exercises.chapter03

/**
 * EXERCISE 3.6] Implement a function, `init`, that returns a `List`
 *               consisting of all but the last element of a `List`.
 */
object Es3_06 {
  def init[A](l: List[A]): List[A] = l match {
    case Nil => throw new NoSuchElementException("List.init: list is empty")
    case x :: Nil => Nil
    case x :: xs => x :: init(xs)
  }
}
