package fpinscala.exercises.chapter03

/**
 * EXERCISE 3.25] Write a function `size` that counts the number of nodes (leaves and branches)
 *                in a tree.
 */
object Es3_25 {
  def size[A](t: Tree[A]): Int = t match {
    case Leaf(_) => 1
    case Branch(l, r) => size(l) + size(r)
  }
}
