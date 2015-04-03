package fpinscala.exercises.chapter05

/**
 * EXERCISE 5.12] Write `fibs`, `from`, `constant`, and `ones` in terms of `unfold`.
 */
object Es5_12 {
  def fibs: Stream[Int] = Stream.unfold((0, 1))(s => {
    val (n1, n2) = s
    Some((n1, (n2, n1 + n2)))
  })

  def from(n: Int): Stream[Int] = Stream.unfold(n)(s => Some((s, s + 1)))

  def constant[A](n: A): Stream[A] = Stream.unfold(n)(same)

  def ones: Stream[Int] = constant(1)

  private def same[A](default: A): Option[(A, A)] = Some((default, default))
}
