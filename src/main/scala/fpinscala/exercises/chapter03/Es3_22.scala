package fpinscala.exercises.chapter03

/**
 * EXERCISE 3.22] Write a function that accepts two lists and constructs a new list by adding
 *                corresponding elements. For example, List(1,2,3) and List(4,5,6) become List(5,7,9)
 */
object Es3_22 {
  def add(as: List[Int], bs: List[Int]): List[Int] = (as, bs) match {
    case (x :: xs, y :: ys) => (x + y) :: add(xs, ys)
    case _ => Nil
  }
}
