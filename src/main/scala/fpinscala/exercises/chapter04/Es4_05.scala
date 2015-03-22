package fpinscala.exercises.chapter04

/**
 * EXERCISE 4.5] Implement this function. It’s straightforward to do using `map` and
 *               `sequence`, but try for a more efficient implementation that only
 *               looks at the list once. In fact, implement `sequence` in terms
 *               of `traverse`.
 */
object Es4_05 {
  def sequence[A](a: List[Option[A]]): Option[List[A]] = traverse(a)(x => x)

  def traverse[A, B](a: List[A])(f: A => Option[B]): Option[List[B]] = {
    val step = mapOpt(f) _
    a.foldRight(Option(List.empty[B]))(step)
  }

  private def mapOpt[A, B](f: A => Option[B])(x: A, acc: Option[List[B]]): Option[List[B]] = {
    (f(x), acc) match {
      case (None, _) => None
      case (_, None) => None
      case (Some(y), Some(ys)) => Some(y :: ys)
    }
  }
}
