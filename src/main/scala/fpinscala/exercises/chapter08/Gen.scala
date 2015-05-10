package fpinscala.exercises.chapter08

trait Gen[A]

object Gen {
  def choose[A](min: A, max: A): A = ???
  def listOf[A](a: Gen[A]): Gen[List[A]] = ???
  def listOfN[A](n: Int, a: Gen[A]): Gen[List[A]] = ???
}

