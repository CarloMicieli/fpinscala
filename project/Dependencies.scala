import sbt._

object scalac {
  final val `2.11.8` = "2.11.8"
  final val `2.12.1` = "2.12.1"
  final val `2.12.2` = "2.12.2"
}

object Version {
  final val ScalaTest      = "3.0.1"
  final val ScalaCheck     = "1.13.5"
}

object Library {
  val ScalaTest      = "org.scalatest"  %% "scalatest"  % Version.ScalaTest
  val ScalaCheck     = "org.scalacheck" %% "scalacheck" % Version.ScalaCheck
}
