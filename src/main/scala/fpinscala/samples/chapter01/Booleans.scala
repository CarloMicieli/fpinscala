package fpinscala.samples.chapter01

object Booleans {
  def andAlso(a: Boolean, b: => Boolean): Boolean = if (a) b else false

  def orElse(a: Boolean, b: => Boolean): Boolean = if (a) true else b

  def exOr(a: Boolean, b: Boolean): Boolean = (a, b) match {
    case (true, true) => false
    case (x, y) => x || y
  }
}
