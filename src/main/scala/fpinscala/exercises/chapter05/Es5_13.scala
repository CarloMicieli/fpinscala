package fpinscala.exercises.chapter05

/**
 * EXERCISE 5.13] Use `unfold` to implement `map`, `take`, `takeWhile`, `zipWith` (as in chapter 3), and
 *                `zipAll`. The `zipAll` function should continue the traversal as long as either stream
 *                has more elements—it uses `Option` to indicate whether each stream has been
 *                exhausted.
 */
object Es5_13 {
  def map[A, B](st: Stream[A])(f: A => B): Stream[B] =
    Stream.unfold(st) {
      case Empty => None
      case Cons(h, t) => Some((f(h()), t()))
    }

  def take[A](st: Stream[A])(n: Int): Stream[A] =
    Stream.unfold((st, n)) {
      case (Empty, _) => None
      case (_, 0) => None
      case (Cons(h, t), i) => Some((h(), (t(), i - 1)))
    }

  def takeWhile[A](st: Stream[A])(p: A => Boolean): Stream[A] =
    Stream.unfold(st) {
      case Empty => None
      case Cons(h, t) =>
        val head = h()
        if (p(head)) Some(head, t())
        else None
    }

  def zipWith[A, B](as: Stream[A], bs: Stream[A])(f: (A, A) => B): Stream[B] =
    Stream.unfold((as, bs)) {
      case (Empty, _) => None
      case (_, Empty) => None
      case (Cons(ah, at), Cons(bh, bt)) => Some(f(ah(), bh()), (at(), bt()))
    }

  def zipAll[A, B](as: Stream[A], bs: Stream[B]): Stream[(Option[A], Option[B])] =
    Stream.unfold((as, bs)) {
      case (Empty, Empty) => None
      case (Empty, Cons(h, t)) => Some((None, Some(h())), (Empty, t()))
      case (Cons(h, t), Empty) => Some((Some(h()), None), (t(), Empty))
      case (Cons(ah, at), Cons(bh, bt)) => Some((Some(ah()), Some(bh())), (at(), bt()))
    }
}
