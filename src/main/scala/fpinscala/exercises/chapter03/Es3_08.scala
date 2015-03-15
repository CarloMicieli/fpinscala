package fpinscala.exercises.chapter03

/**
 * EXERCISE 3.8] See what happens when you pass Nil and Cons themselves to foldRight , like this:
 *               foldRight(List(1,2,3), Nil:List[Int])(Cons(_,_)) . 10 What do you think this
 *               says about the relationship between foldRight and the data constructors of List ?
 */
object Es3_08 {
  def apply(): List[Int] = {
    List(1, 2, 3).foldRight(Nil: List[Int])(_ :: _)
  }
}
