package fpinscala.exercises.chapter08

trait Prop {
  import Prop._

  def check: Either[(FailedCase, SuccessCount), SuccessCount]
  def &&(that: Prop): Prop = new Prop {
    def check = for {
      x <- this.check.right
      y <- that.check.right
    } yield x + y
  }
}

object Prop {
  type SuccessCount = Int
  type FailedCase = String

  def forAll[A](a: Gen[A])(p: A => Boolean): Prop = ???
}
