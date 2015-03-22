package fpinscala.exercises

package object chapter04 {
  implicit def intAppend: Appendable[Int] = new Appendable[Int] {
    def append(a: Int, b: Int) = a + b
  }

  implicit def stringAppend: Appendable[String] = new Appendable[String] {
    def append(a: String, b: String) = a + b
  }

  implicit def seqAppend[A]: Appendable[List[A]] = new Appendable[List[A]] {
    def append(a: List[A], b: List[A]) = a ++ b
  }
}
