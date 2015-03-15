package fpinscala.exercises.chapter03

/**
 * EXERCISE 3.4] Generalize tail to the function drop, which removes the first n elements from a list.
 *               Note that this function takes time proportional only to the number of elements being
 *               dropped—we don’t need to make a copy of the entire List.
 *
 *               def drop[A](l: List[A], n: Int): List[A]
 */
object Es3_4 {
  @annotation.tailrec
  def drop[A](l: List[A], n: Int): List[A] = (n, l) match {
    case (i, _) if i <= 0 => l
    case (_, _ :: xs) => drop(xs, n - 1)
    case (_, Nil) => Nil
  }
}
