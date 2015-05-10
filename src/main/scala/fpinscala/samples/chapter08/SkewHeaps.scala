package fpinscala.samples.chapter08

/**
 * A skew heap (a representation of priority queues), following Chris Okasaki's implementation.
 */
sealed trait SkewHeap[+A] {

  def isEmpty: Boolean

  def deleteMin[B >: A](implicit ord: Ordering[B]): SkewHeap[B] = this match {
    case Empty         => Empty
    case Fork(x, l, r) => merge[B](l, r)
  }

  private def merge[B >: A](a: SkewHeap[B], b: SkewHeap[B])(implicit ord: Ordering[B]): SkewHeap[B] = {

    def join(a: SkewHeap[B], b: SkewHeap[B]): SkewHeap[B] = {
      a match {
        case Fork(x, l, r) => Fork(x, r, merge(l, b))
        case Empty => Empty
      }
    }

    (a, b) match {
      case (Empty, r) => r
      case (l, Empty) => l
      case (l, r) => {
        if (ord.lteq(l.min, r.min))
          join(l, r)
        else
          join(r, l)
      }
    }
  }

  /**
   * Checks whether the current heap is roughly balanced.
   */
  def isBalanced[B >: A](implicit ord: Ordering[B]): Boolean = this match {
    case Empty         => true
    case Fork(_, l, r) => {

      val almostSameWeight: Boolean = {
        val diff: Int = math.abs(l.weight - r.weight)
        diff == 0 || diff == 1
      }

      almostSameWeight && l.isBalanced[B] && r.isBalanced[B]
    }
  }

  def good = this match {
    case Empty         => true
    case Fork(_, l, r) => l.weight <= r.weight
  }

  def credits: Int = this match {
    case Empty           => 0
    case h@Fork(_, l, r) => l.credits + r.credits + (if (h.good) 0 else 1)
  }

  /**
   * It returns the current heap weight.
   */
  def weight: Int = this match {
    case Empty         => 0
    case Fork(_, l, r) => 1 + l.weight + r.weight
  }

  /**
   * It inserts elements into the two subtrees alternately.
   */
  def insert[B >: A](x: B)(implicit ord: Ordering[B]): SkewHeap[B] = {
    def minMax(x: B, y: B): (B, B) = if (ord.lt(x, y)) (x, y) else (y, x)

    this match {
      case Empty         => Fork(x, Empty, Empty)
      case Fork(y, l, r) => {
        val (min, max) = minMax(x, y)
        Fork(min, r, l.insert(max))
      }
    }
  }

  /**
   * It extract the minimum element (i.e. the first element in the queue)
   */
  def minOption: Option[A] = this match {
    case Empty         => None
    case Fork(x, _, _) => Some(x)
  }

  /**
   * It extract the minimum element (i.e. the first element in the queue)
   */
  def min: A = minOption.getOrElse(throw new NoSuchElementException("no elements"))

  /**
   * It checks the heap invariant: the value in each node is
   * less than any value in its subtrees.
   */
  def isValid[B >: A](implicit ord: Ordering[B]): Boolean = {
    def smaller(v: B, t: SkewHeap[B]): Boolean = {
      (v, t) match {
        case (_, Empty)         => true
        case (x, Fork(y, l, r)) => ord.lteq(x, y) && t.isValid
      }
    }

    this match {
      case Empty         => true
      case Fork(x, l, r) => smaller(x, l) && smaller(x, r)
    }
  }
}

object SkewHeap {
  def empty[A]: SkewHeap[A] = Empty

  def heap[A](items: A*)(implicit ord: Ordering[A]): SkewHeap[A] =
    if (items.isEmpty)
      Empty
    else {
      val h = heap(items.tail: _*)
      h.insert(items.head)
    }

  def fromList[A](xs: List[A])(implicit ord: Ordering[A]): SkewHeap[A] = {
    xs.foldLeft(empty[A])((h, x) => h.insert(x))
  }

  def unit[A](n: A): SkewHeap[A] = Fork(n, Empty, Empty)
  def range(min: Int, max: Int): SkewHeap[Int] = {
    val xs = (min to max).toList
    SkewHeap.fromList(xs)
  }
}

case object Empty extends SkewHeap[Nothing] {
  def isEmpty = true
}

case class Fork[A](a: A, l: SkewHeap[A], r: SkewHeap[A]) extends SkewHeap[A] {
  def isEmpty = false
}