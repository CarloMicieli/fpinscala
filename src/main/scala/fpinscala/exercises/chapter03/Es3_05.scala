package fpinscala.exercises.chapter03

/**
 * EXERCISE 3.5] Implement dropWhile, which removes elements from the List prefix as long as they
 *               match a predicate.
 */
object Es3_05 {
  @annotation.tailrec
  def dropWhile[A](l: List[A])(p: A => Boolean): List[A] = l match {
    case x :: xs => if (p(x)) dropWhile(xs)(p) else l
    case Nil => Nil
  }
}
