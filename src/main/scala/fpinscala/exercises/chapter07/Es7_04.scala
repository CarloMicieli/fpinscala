package fpinscala.exercises.chapter07

import Par._

/**
 * EXERCISE 7.4] This API already enables a rich set of operations. Here's a simple example: using
 *               `lazyUnit`, write a function to convert any function `A => B` to one that evaluates
 *               its result asynchronously.
 */
object Es7_04 {
  def asyncF[A, B](f: A => B): A => Par[B] = a => Par.lazyUnit(f(a))
}
