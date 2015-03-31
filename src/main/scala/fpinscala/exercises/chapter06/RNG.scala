package fpinscala.exercises.chapter06

trait RNG {
  def nextInt: (Int, RNG)
}

trait Rand[A]