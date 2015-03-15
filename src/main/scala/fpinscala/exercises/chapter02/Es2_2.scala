package fpinscala.exercises.chapter02

/**
 * EXERCISE 2.2] Implement isSorted , which checks whether an Array[A] is sorted according to a
 *               given comparison function:
 *               def isSorted[A](as: Array[A], ordered: (A,A) => Boolean): Boolean
 */
object Es2_2 {
  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = as match {
    case Array() | Array(_) => true
    case _ =>
      @annotation.tailrec
      def loop(i: Int, sorted: Boolean = true): Boolean = {
        if (i + 1 >= as.length) sorted
        else {
          loop(i + 1, ordered(as(i), as(i + 1)) && sorted)
        }
      }
      loop(0)
  }

  // Like EXERCISE 2.2], but for lists
  def isSorted[A](xs: List[A])(implicit ev: A => Ordered[A]): Boolean = {
    !xs.zip(xs.tail).exists { case (i, j) => i > j }
  }
}
