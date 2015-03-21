package fpinscala.exercises.chapter03

/**
 * EXERCISE 3.27] Write a function `depth` that returns the maximum path length from the root
 *                of a tree to any leaf.
 */
object Es3_27 {
  def depth[A](t: Tree[A]): Int = t match {
    case Leaf(_) => 1
    case Branch(l, r) => 1 + (depth(l) max depth(r))
  }
}
