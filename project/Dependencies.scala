import sbt._

object Version {
  final val ScalaTest      = "3.0.3"
  final val ScalaCheck     = "1.13.4"
}

object Dependencies {
  val scalaTest  = "org.scalatest"  %% "scalatest" % Version.ScalaTest
  val scalaCheck = "org.scalacheck" %% "scalacheck" % Version.ScalaCheck
}

object Scalac {
  final val `2.12.4`: String = "2.12.4"
}
