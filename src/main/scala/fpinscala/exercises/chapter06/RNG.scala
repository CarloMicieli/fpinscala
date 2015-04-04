package fpinscala.exercises.chapter06

trait RNG {
  def nextInt: (Int, RNG)

  def nextDouble: (Double, RNG)
}

object RNG {
  type Rand[+A] = RNG => (A, RNG)

  val int: Rand[Int] = _.nextInt

  def unit[A](a: A): Rand[A] = rng => (a, rng)

  def map[A, B](s: Rand[A])(f: A => B): Rand[B] = rng => {
    val (a, rng2) = s(rng)
    (f(a), rng2)
  }

  def map2[A, B, C](ra: Rand[A], rb: Rand[B])(f: (A, B) => C): Rand[C] = rng => {
    val (a, rng2) = ra(rng)
    val (b, rng3) = rb(rng2)
    (f(a, b), rng3)
  }

  def both[A, B](ra: Rand[A], rb: Rand[B]): Rand[(A, B)] =
    map2(ra, rb)((_, _))
}

case class SimpleRNG(seed: Long) extends RNG {
  def nextInt: (Int, RNG) = {
    val newSeed = (seed * 0x5DEECE66DL + 0xBL) & 0xFFFFFFFFFFFFL
    val nextRNG = SimpleRNG(newSeed)
    val n = (newSeed >>> 16).toInt
    (n, nextRNG)
  }

  def nextDouble: (Double, RNG) = {
    def toDouble(n: Int): Double = {
      math.abs(n) / Int.MaxValue.toDouble
    }
    val (n1, rng2) = nextInt
    (toDouble(n1), rng2)
  }

  def randomPair: ((Int, Int), RNG) =
    RNG.both(_.nextInt, _.nextInt)(this)
}