package fpinscala.exercises.chapter07

import Par._

/**
 * EXERCISE 7.5] Hard: Write this function, called `sequence`. No additional primitives are required.
 *               Do not call `run`.
 */
object Es7_05 {
  def sequence[A](ps: List[Par[A]]): Par[List[A]] =
    ps.foldLeft(unit(List.empty[A]))(step)

  private def step[A](as: Par[List[A]], a: Par[A]): Par[List[A]] =
    Par.map2(a, as)(_ :: _)
}
