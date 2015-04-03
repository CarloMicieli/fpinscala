package fpinscala.exercises.chapter05

/**
 * EXERCISE 5.7] Implement `map`, `filter`, `append`, and `flatMap` using `foldRight`.
 *               The `append` method should be non-strict in its argument.
 */
object Es5_07 {
  def map[A, B](stream: Stream[A])(f: A => B): Stream[B] =
    stream.foldRight(Stream.empty[B])((a, b) => Stream.cons(f(a), b))

  def filter[A](stream: Stream[A])(f: A => Boolean): Stream[A] =
    stream.foldRight(Stream.empty[A])((a, b) => if (f(a)) Stream.cons(a, b) else b)

  def append[A](a: Stream[A], b: => Stream[A]): Stream[A] =
    a.foldRight(b)((a, b) => Stream.cons(a, b))

  def flatMap[A, B](stream: Stream[A])(f: A => Stream[B]): Stream[B] =
    stream.foldRight(Stream.empty[B])((a, b) => f(a).append(b))
}
