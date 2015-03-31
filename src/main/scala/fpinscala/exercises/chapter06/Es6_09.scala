package fpinscala.exercises.chapter06

/**
 * EXERCISE 6.9] Reimplement `map` and `map2` in terms of `flatMap`. The fact that this is possible is what
 *               we’re referring to when we say that `flatMap` is more powerful than `map` and `map2`.
 */
object Es6_09 {
  def map[A, B](s: Rand[A])(f: A => B): Rand[B] = ???

  def map2[A, B, C](ra: Rand[A], rb: Rand[B])(f: (A, B) => C): Rand[C] = ???
}
