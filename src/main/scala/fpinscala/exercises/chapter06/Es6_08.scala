package fpinscala.exercises.chapter06

import RNG._

/**
 * EXERCISE 6.8] Implement `flatMap`, and then use it to implement `nonNegativeLessThan`.
 */
object Es6_08 {
  def flatMap[A, B](f: Rand[A])(g: A => Rand[B]): Rand[B] = ???
}
