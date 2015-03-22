package fpinscala.exercises.chapter04

/**
 * EXERCISE 4.3] Write a generic function `map2` that combines two `Option`s values using a binary function.
 *               If either `Option` value is `None`, then the return value is too.
 */
object Es4_03 {
  def map2[A, B, C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] = {
    for {
      x <- a
      y <- b
    } yield f(x, y)
  }

  def map2V2[A, B, C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] = {
    a.flatMap(x =>
      b.map(y => f(x, y))
    )
  }
}
