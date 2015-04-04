package fpinscala.exercises.chapter06

object State {
  type State[S, +A] = S => (A, S)

  def map[S, A, B](state: State[S, A])(f: A => B): State[S, B] = s => {
    val (a, s2) = state(s)
    (f(a), s2)
  }

  def map2[S, A, B, C](as: State[S, A], bs: State[S, B])(f: (A, B) => C): State[S, C] = s => {
    val (a, s2) = as(s)
    val (b, s3) = bs(s2)
    (f(a, b), s3)
  }

  def unit[S, A](a: A): State[S, A] = s => (a, s)

  def flatMap[S, A, B](state: State[S, A])(f: A => State[S, B]): State[S, B] = s => {
    val (a, s2) = state(s)
    f(a)(s2)
  }

  def sequence[S, A](fs: List[State[S, A]]): State[S, List[A]] = {
    def step(state: State[S, A], out: State[S, List[A]]): State[S, List[A]] = s => {
      val (la, lsa) = out(s)
      val (a, sa) = state(lsa)
      (a :: la, sa)
    }
    val zero = unit[S, List[A]](List.empty[A])
    fs.foldRight(zero)(step)
  }
}
