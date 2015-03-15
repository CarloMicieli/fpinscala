package fpinscala.samples.chapter02

object FindFirst {
  def apply[A](array: Array[A])(p: A => Boolean): Option[Int] = {
    @annotation.tailrec
    def loop(i: Int): Option[Int] = {
      if (i == array.size) None
      else {
        if (p(array(i)))
          Some(i)
        else
          loop(i + 1)
      }
    }

    loop(0)
  }
}
