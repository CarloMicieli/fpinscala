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

    it("should check whether an Option is empty") {
      None.isEmpty should be(true)
      Some(42).isEmpty should be(false)
    }

    it("should get the value inside an option, if some") {
      val just = Some(42)
      assert(just.get == 42)
    }

    it("should throw an exception getting the value from a None") {
      intercept[NoSuchElementException] {
        None.get
      }
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

    it("should flatMap over Option values") {
      val just = Some(42)
      val answer = just.flatMap(v => Some("answer"))
      assert(answer == Some("answer"))
    }

    it("should get the value, or return an alternative value if None") {
      assert(Some(42).getOrElse(-1) == 42)
      assert(None.getOrElse(-1) == -1)
    }

    it("should an alternative Option if None") {
      assert(Some(42).orElse(Some(-1)) == Some(42))
      assert(None.orElse(Some(42)) == Some(42))
    }

    it("should filter an Option") {
      val answer = Some(42)

      assert(answer.filter(_ % 2 == 0) == Some(42))
      assert(answer.filter(_ % 2 != 0) == None)
      assert(None.filter((x: Int) => x > 0) == None)
    }
  }
}
