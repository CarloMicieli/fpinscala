package fpinscala.exercises

import org.scalacheck.{Arbitrary, Gen}
import org.scalacheck.util.Buildable

import scala.collection.mutable
import scala.language.implicitConversions

package object chapter03 {

  implicit def listToTraversable[T](list: List[T]): Traversable[T] = new Traversable[T] {
    override def foreach[U](f: (T) => U): Unit = list.foreach(f)
  }

  implicit def arbList[T](implicit a: Arbitrary[T]): Arbitrary[List[T]] = Arbitrary {
    val genEmptyList = Gen.const(List.empty[T])
    val genSingletonList = for (e <- Arbitrary.arbitrary[T]) yield List(e)

    def genList(sz: Int): Gen[List[T]] = Gen.containerOfN[List, T](sz, Arbitrary.arbitrary[T])

    def sizedList(sz: Int) =
      if (sz <= 0) genEmptyList
      else Gen.frequency((1, genEmptyList), (1, genSingletonList), (8, genList(sz)))

    Gen.sized(sz => sizedList(sz))
  }

  implicit def buildableList[T]: Buildable[T, List[T]] = new Buildable[T, List[T]] {
    def builder = new mutable.Builder[T, List[T]]() {
      private var list = List.empty[T]

      override def +=(elem: T): this.type = {
        list = elem :: list
        this
      }

      override def result(): List[T] = list

      override def clear(): Unit = list = List.empty[T]
    }
  }
}
