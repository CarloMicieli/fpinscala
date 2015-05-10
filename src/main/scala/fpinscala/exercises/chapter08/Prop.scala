package fpinscala.exercises.chapter08

trait Prop {
  def check: Boolean
  def &&(that: Prop): Prop = new Prop {
    def check = this.check && that.check
  }
}

object Prop {
  def forAll[A](a: Gen[A])(p: A => Boolean): Prop = ???
}
