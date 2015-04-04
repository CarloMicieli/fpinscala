package fpinscala.exercises.chapter06

import RNG._

/**
 * EXERCISE 6.7] Hard: If you can combine two `RNG` transitions, you should be able to combine a whole
 *               list of them. Implement sequence for combining a `List` of transitions into a single
 *               transition. Use it to reimplement the `ints` function you wrote before. For the latter,
 *               you can use the standard library function `List.fill(n)(x)` to make a list with `x`
 *               repeated `n` times.
 */
object Es6_07 {
  def sequence[A](fs: List[Rand[A]]): Rand[List[A]] =
    fs.foldRight(unit(List.empty[A]))(step)

  private def step[A](r: Rand[A], rs: Rand[List[A]]): Rand[List[A]] =
    map2(r, rs)((x, xs) => x :: xs)
}
