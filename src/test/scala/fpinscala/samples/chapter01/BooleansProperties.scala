package fpinscala.samples.chapter01

import Booleans._
import org.scalacheck._

object AndAlsoProperties extends Properties("andAlso") {
  import Prop.forAll

  property("must return the same value as built in operator") = forAll { (a: Boolean, b: Boolean) =>
    andAlso(a, b) == (a && b)
  }

  property("must always return 'false' when one argument is false") = forAll { (a: Boolean) =>
    !andAlso(a, false)
  }

  property("must return the argument when they are the same") = forAll { (a: Boolean) =>
    andAlso(a, a) == a
  }
}

object OrElseProperties extends Properties("orElse") {
  import Prop.forAll

  property("must return the same result as the builtin operator") = forAll { (a: Boolean, b: Boolean) =>
    orElse(a, b) == (a || b)
  }

  property("must always return 'true' when one argument is true") = forAll { (a: Boolean) =>
    orElse(a, true)
  }
}

object ExOrProperties extends Properties("exOr") {
  import Prop.forAll

  property("must return 'true' when exactly one argument is 'true'") = forAll { (a: Boolean) =>
    exOr(a, !a)
  }

  property("must have the right behaviour over booleans") = forAll { (a: Boolean, b: Boolean) =>
    exOr(a, b) == (a != b)
  }

}