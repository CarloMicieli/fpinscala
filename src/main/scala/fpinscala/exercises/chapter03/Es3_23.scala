package fpinscala.exercises.chapter03

/**
 * EXERCISE 3.23] Generalize the function you just wrote so that it's not specific to integers
 *                or addition. Name your generalized function `zipWith`.
 */
object Es3_23 {
  def zipWith[A, B](as: List[A], bs: List[A])(f: (A, A) => B): List[B] = (as, bs) match {
    case (x :: xs, y :: ys) => f(x, y) :: zipWith(xs, ys)(f)
    case _ => Nil
  }
}
