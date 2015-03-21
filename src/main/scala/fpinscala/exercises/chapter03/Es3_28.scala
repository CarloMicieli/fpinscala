package fpinscala.exercises.chapter03

/**
 * EXERCISE 3.28] Write a function `map`, analogous to the method of the same name on `List`,
 *                that modifies each element in a tree with a given function.
 */
object Es3_28 {
  def map[A, B](tree: Tree[A])(f: A => B): Tree[B] = tree match {
    case Leaf(v) => Leaf(f(v))
    case Branch(l, r) => Branch(map(l)(f), map(r)(f))
  }
}
