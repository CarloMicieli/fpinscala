package fpinscala.samples.chapter08

sealed trait Op
case class  Insert(v: Int) extends Op
case object DeleteMin      extends Op

object Ops {
  def toHeap(xs: List[Op]): SkewHeap[Int] = {
    val step = (heap: SkewHeap[Int], op: Op) => (heap, op) match {
      case (Empty, DeleteMin) => Empty
      case (h, Insert(x))     => h.insert(x)
      case (h, DeleteMin)     => h.deleteMin
    }
    xs.foldLeft(SkewHeap.empty[Int])(step)
  }
}