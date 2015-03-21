package fpinscala.exercises.chapter03

/**
 * EXERCISE 3.13] Can you write `foldLeft` in terms of `foldRight`? How about the other way
 *                around? Implementing `foldRight` via `foldLeft` is useful because it lets us
 *                implement `foldRight` tail-recursively, which means it works even for large
 *                lists without overflowing the stack.
 */
object Es3_13 {
  def foldRight[A, B](list: List[A], z: B)(f: (A, B) => B): B = {
    list.reverse.foldLeft(z)((xs, x) => f(x, xs))
  }

  def foldLeft[A, B](list: List[A], z: B)(f: (B, A) => B): B = {
    list.reverse.foldRight(z)((x, xs) => f(xs, x))
  }
}
