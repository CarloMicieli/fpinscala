package fpinscala.exercises.chapter04

import org.scalatest.{FunSpec, Matchers}

class OptionSpecs extends FunSpec with Matchers {
  describe("An Option value") {
    it("should be None or Just") {
      val just = Option(42)
      val none = Option(null)
      just should be(Some(42))
      none should be(None)
    }

    it("should produce string representations") {
      val just = Some(42)
      val none = None
      just.toString should be("Some(42)")
      none.toString should be("None")
    }

    it("should check whether two values are equal") {
      val x = Some(42)
      val y = Some(42)
      val w = Some(24)
      val z = None
      x == y should be(true)
      x != w should be(true)
      z == z should be(true)
    }

    it("should map over Option values") {
      val just = Some(21)
      val doubled = just.map { _ * 2}
      doubled.get should be(42)

      val none: Option[Int] = None
      val stillNone = none.map { _ * 2}
      stillNone should be(None)
    }
  }
}
