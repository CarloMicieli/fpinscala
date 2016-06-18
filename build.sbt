import scalariform.formatter.preferences._
import com.typesafe.sbt.SbtScalariform
import com.typesafe.sbt.SbtScalariform.ScalariformKeys

name := "fpinscala"

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.11.8"

homepage := Some(url("https://github.com/CarloMicieli/fpinscala"))

scalacOptions ++= Seq(
  "-target:jvm-1.8",
  "-encoding", "UTF-8",
  "-deprecation",
  "-feature",
  "-unchecked",
  "-Xfatal-warnings",
  "-Xlint",
  "-Yno-adapted-args",
  "-Ywarn-unused-import",
  "-Ywarn-numeric-widen",
  "-Ywarn-infer-any",
  "-Ywarn-value-discard",
  "-Ywarn-inaccessible",
  "-Ywarn-dead-code",
  "-J-Xss6M"
)

scalacOptions in (Compile, console) --= Seq(
  "-Xfatal-warnings",
  "-Ywarn-unused-import"
)

libraryDependencies ++= Seq(
  "org.scalatest"  %% "scalatest" % "2.2.6" % "test",
  "org.scalacheck" %% "scalacheck" % "1.12.5" % "test"
)

// Scalariform settings
lazy val scalaProject = (project in file(".")).enablePlugins(SbtScalariform)

SbtScalariform.scalariformSettings

ScalariformKeys.preferences := ScalariformKeys.preferences.value
  .setPreference(AlignSingleLineCaseStatements, true)
  .setPreference(DoubleIndentClassDeclaration, true)
  .setPreference(PlaceScaladocAsterisksBeneathSecondAsterisk, true)
  .setPreference(PreserveDanglingCloseParenthesis, true)

fork in run := true
