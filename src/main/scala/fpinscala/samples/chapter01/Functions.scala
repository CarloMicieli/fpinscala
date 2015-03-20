package fpinscala.samples.chapter01

object Functions {
  def max[A](a: A, b: A)(implicit ev: A => Ordered[A]): A =
    if (a > b) a else b

  def min[A](a: A, b: A)(implicit ev: A => Ordered[A]): A =
    if (a < b) a else b
}
