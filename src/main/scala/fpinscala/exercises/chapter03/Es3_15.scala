package fpinscala.exercises.chapter03

/**
 * EXERCISE 3.15] Hard: Write a function that concatenates a list of lists into a single list.
 *                Its runtime should be linear in the total length of all lists. Try to use
 *                functions we have already defined.
 */
object Es3_15 {

  def concat[A](list: List[List[A]]): List[A] =
    list.foldRight(List.empty[A])((xss, xs) => xss ++ xs)
}
