package fpinscala.samples.chapter05

object LazyEval {
  def cond1[A](cond: Boolean, onTrue: A, onFalse: A): A =
    if (cond) onTrue else onFalse

  def cond2[A](cond: Boolean, onTrue: () => A, onFalse: () => A): A =
    if (cond) onTrue() else onFalse()

  def cond3[A](cond: Boolean, onTrue: => A, onFalse: => A): A =
    if (cond) onTrue else onFalse

  def maybeTwice(cond: Boolean, i: => Int): Int = if (cond) i + i else 0

  def maybeTwice2(cond: Boolean, i: => Int): Int = {
    lazy val n = i
    if (cond) {
      n + n
    }
    else 0
  }
}
