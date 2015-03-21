package fpinscala.exercises.chapter03

/**
 * EXERCISE 3.10] Our implementation of `foldRight` is not tail-recursive and will result in a StackOverflowError
 *                for large lists (we say it’s not stack-safe). Convince yourself that this is the
 *                case, and then write another general list-recursion function, `foldLeft`, that is
 *                tail-recursive, using the techniques we discussed in the previous chapter.
 */
object Es3_10 {
  private val veryLongList = initList

  def blowTheStack(): Unit = {
    // with a size of 1000000 elements this call blows the stack on my box.
    veryLongList.foldRight(0L)(_ + _)
  }

  def stackSafeCount(): Long = {
    veryLongList.foldLeft(0L)(_ + _)
  }

  private def initList: List[Int] = {
    (1000000 to 1 by -1).foldLeft(List.empty[Int])((acc, x) => x :: acc)
  }

}
