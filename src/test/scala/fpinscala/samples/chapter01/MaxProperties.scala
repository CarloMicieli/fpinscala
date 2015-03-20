package fpinscala.samples.chapter01

import Functions._
import org.scalacheck._

object MaxProperties extends Properties("max") {
  import org.scalacheck.Prop.{forAll, BooleanOperators}

  property("must be one of the arguments") = forAll { (a: Int, b: Int) =>
    max(a, b) == a || max(a, b) == b
  }

  property("must be greater or equal of both arguments") = forAll { (a: Int, b: Int) =>
    val maxValue: Int = max(a, b)
    (maxValue >= a) && (maxValue >= b)
  }

  property("must find max when the two args are equals") = forAll { (a: Int) =>
    max(a, a) == a
  }

  property("must be the inverse of min") = forAll { (a: Int, b: Int) =>
    (max(a, b) != min(a, b)) ==> (a != b)
  }
}
