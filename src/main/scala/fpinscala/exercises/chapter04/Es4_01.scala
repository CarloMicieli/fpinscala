package fpinscala.exercises.chapter04

/**
 * EXERCISE 4.1] Implement all of the preceding functions on `Option`. As you implement each function,
 *               try to think about what it means and in what situations you'd use it.
 */
object Es4_01 {

  def answer(n: Int): Option[String] =
    step1(n).map(v => 84 / v).flatMap(step2)

  private def step1(n: Int): Option[Int] =
    if (n > 0) Some(n) else None

  private def step2(n: Int): Option[String] =
    if (n == 42) Some("life universe and everything") else None
}
