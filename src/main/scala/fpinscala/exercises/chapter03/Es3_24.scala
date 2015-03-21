package fpinscala.exercises.chapter03

/**
 * EXERCISE 3.24] Hard: As an example, implement `hasSubsequence` for checking whether a `List`
 *                contains another `List` as a subsequence. For instance, `List(1,2,3,4)` would have
 *                `List(1,2)`, `List(2,3)`, and `List(4)` as subsequences, among others. You may have
 *                some difficulty finding a concise purely functional implementation that is also
 *                efficient. That's okay. Implement the function however comes most naturally.
 *
 *                Note: Any two values `x` and `y` can be compared for equality in Scala using the expression `x == y`.
 */
object Es3_24 {
  def hasSubsequence[A](sup: List[A], sub: List[A]): Boolean = {
    val zero = (false, sub)
    val step: ((Boolean, List[A]), A) => (Boolean, List[A]) = (acc, x) => {
      val (isSub, matched) = acc
      matched match {
        case Nil => (isSub, sub)
        case y :: ys => if (x == y) (true, ys) else (false, sub)
      }
    }

    if (sub.isEmpty) true
    else {
      val (isSub, notMatched) = sup.foldLeft(zero)(step)
      isSub && notMatched.isEmpty
    }
  }
}