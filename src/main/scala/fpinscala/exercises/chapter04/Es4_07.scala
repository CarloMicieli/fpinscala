package fpinscala.exercises.chapter04

/**
 * EXERCISE 4.7] Implement `sequence` and `traverse` for `Either`. These should return
 *               the first error that's encountered, if there is one.
 */
object Es4_07 {
  def sequence[E, A](es: List[Either[E, A]]): Either[E, List[A]] =
    traverse(es)(x => x)

  def traverse[E, A, B](as: List[A])(f: A => Either[E, B]): Either[E, List[B]] = {
    val fu = step[E, A, B](f) _
    as.foldRight(zero[E, B])(fu)
  }

  private def zero[E, B]: Either[E, List[B]] = Right(List.empty[B])

  private def step[E, A, B](f: A => Either[E, B])(x: A, acc: Either[E, List[B]]): Either[E, List[B]] = {
    (f(x), acc) match {
      case (l@Left(y), _) => l
      case (_, l@Left(y)) => l
      case (Right(y), Right(ys)) => Right(y :: ys)

    }
  }
}
