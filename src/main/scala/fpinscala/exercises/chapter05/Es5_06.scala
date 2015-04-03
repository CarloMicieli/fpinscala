package fpinscala.exercises.chapter05

/**
 * EXERCISE 5.6] Hard: Implement `headOption` using `foldRight`.
 */
object Es5_06 {
  def headOption[A](stream: Stream[A]): Option[A] = {
    val z: Option[A] = None
    stream.foldRight(z)((a, b) => Some(a))
  }
}