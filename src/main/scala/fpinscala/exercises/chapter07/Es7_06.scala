package fpinscala.exercises.chapter07

import Par._

/**
 * EXERCISE 7.6] Implement `parFilter`, which filters elements of a list in parallel.
 */
object Es7_06 {
  def parFilter[A](as: List[A])(f: A => Boolean): Par[List[A]] = {
    val len = as.length
    if (len <= 1)
      unit(as.filter(f))
    else {
      val (l, r) = as.splitAt(len / 2)
      map2(fork(parFilter(l)(f)), fork(parFilter(r)(f)))(_ ++ _)
    }
  }
}
