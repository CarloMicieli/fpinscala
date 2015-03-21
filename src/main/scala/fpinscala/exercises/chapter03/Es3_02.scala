package fpinscala.exercises.chapter03

/**
 * EXERCISE 3.2] Implement the function `tail` for removing the first element of a `List`. Note that the
 *               function takes constant time. What are different choices you could make in your
 *               implementation if the `List` is `Nil`?
 */
object Es3_02 {
  def tail[A](list: List[A]): List[A] = list match {
    case _ :: xs => xs
  }

  def tailOption[A](list: List[A]): List[A] = list match {
    case _ :: xs => xs
    case _ => Nil
  }
}
