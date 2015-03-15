package fpinscala.exercises.chapter03

/**
 * EXERCISE 3.7] Can product , implemented using foldRight, immediately halt the recursion and
 *               return 0.0 if it encounters a 0.0 ? Why or why not? Consider how any short-circuiting
 *               might work if you call foldRight with a large list.
 */
object Es3_07 {
  def product(list: List[Int]): Int = list.foldLeft(1)(_ * _)

  def lazyProduct[A, B >: A](list: List[A])(implicit num: Numeric[B]): B = {
    def continue(x: B, acc: => B): B =
      if (x == num.zero) x
      else acc
    list.foldRight(continue, num.one)(num.times)
  }
}
