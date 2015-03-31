package fpinscala.exercises.chapter04

import Es4_03._

/**
 * EXERCISE 4.4] Write a function sequence that combines a list of `Option`s into one
 *               `Option` containing a list of all the `Some` values in the original list.
 *               If the original list contains `None` even once, the result of the function
 *               should be `None`; otherwise the result should be `Some` with a list of
 *               all the values.
 */
object Es4_04 {
  def sequence[A](a: List[Option[A]]): Option[List[A]] = {
    @annotation.tailrec
    def loop(list: List[Option[A]], acc: List[A]): Option[List[A]] = list match {
      case Some(x) :: xs => loop(xs, x :: acc)
      case None :: _ => None
      case Nil => Some(acc.reverse)
    }

    loop(a, List.empty[A])
  }

  def sequenceV2[A](a: List[Option[A]]): Option[List[A]] = {
    val step = (x: Option[A], xs: Option[List[A]]) => map2(x, xs)(_ :: _)
    a.foldRight(Option(List.empty[A]))(step)
  }
}
