package fpinscala.exercises.chapter03

/**
 * EXERCISE 3.14] Implement `append` in terms of either `foldLeft` or `foldRight`.
 */
object Es3_14 {
  def append[A](as: List[A], bs: List[A]): List[A] = appendL(as, bs)

  def appendR[A](as: List[A], bs: List[A]): List[A] = as.foldRight(bs)(_ :: _)

  def appendL[A](as: List[A], bs: List[A]): List[A] =
    as.reverse.foldLeft(bs)((xs, x) => x :: xs)
}
