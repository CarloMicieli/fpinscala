package fpinscala.exercises.chapter06

/**
 * EXERCISE 6.4] Write a function to generate a list of random integers.
 */
object Es6_04 {
  def ints(count: Int)(rng: RNG): (List[Int], RNG) = {
    def step(n: Int, p: (List[Int], RNG)): (List[Int], RNG) = {
      val (xs, rng) = p
      val (n, rng2) = rng.nextInt
      (n :: xs, rng2)
    }

    (1 to count).toList.foldRight((List.empty[Int], rng))(step)
  }
}
