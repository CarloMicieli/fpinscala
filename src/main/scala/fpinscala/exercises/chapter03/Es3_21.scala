package fpinscala.exercises.chapter03

/**
 * EXERCISE 3.21] Use `flatMap` to implement `filter`.
 */
object Es3_21 {
  def filter[A](as: List[A])(p: A => Boolean): List[A] =
    as.flatMap(x => if (p(x)) List(x) else List())
}
