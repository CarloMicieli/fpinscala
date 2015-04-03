package fpinscala.exercises.chapter05

/**
 * EXERCISE 5.5] Use `foldRight` to implement `takeWhile`.
 */
object Es5_05 {
  def takeWhile[A](stream: Stream[A])(p: A => Boolean): Stream[A] = {
    def step(x: A, xs: => Stream[A]): Stream[A] =
      if (p(x))
        Stream.cons(x, xs)
      else
        Stream.empty[A]

    stream.foldRight(Stream.empty[A])(step)
  }
}
