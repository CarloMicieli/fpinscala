package fpinscala.exercises.chapter03

/**
 * EXERCISE 3.15] Hard: Write a function that concatenates a list of lists into a single list.
 *                Its runtime should be linear in the total length of all lists. Try to use
 *                functions we have already defined.
 */
object Es3_15 {
  def concat[A](list: List[List[A]]): List[A] =
    list.foldRight(List.empty[A])((xss, xs) => xss ++ xs)

  /*

    concat(List(List(1, 2), List(3), List(4, 5)) evaluate to
    (List(1, 2) ++ (List(3) ++ (Nil ++ List(4,5))))

    Nil ++ List(4,5)            => 0 steps
    List(3) ++ List(4,5)        => 1 step
    List(1, 2) ++ List(3, 4, 5) => 2 steps
                                   --------
                                   3 steps ~ O(n)

   */
}
