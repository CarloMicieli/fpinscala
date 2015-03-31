package fpinscala.exercises.chapter07

/**
 * EXERCISE 7.12] There’s still something rather arbitrary about choiceN. The choice of List seems
 *                overly specific. Why does it matter what sort of container we have? For instance, what
 *                if, instead of a list of computations, we have a Map of them
 */
object Es7_12 {
  def choiceMap[K, V](key: Par[K])(choices: Map[K, Par[V]]): Par[V] = ???
}
