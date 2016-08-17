import scalariform.formatter.preferences._
import com.typesafe.sbt.SbtScalariform
import com.typesafe.sbt.SbtScalariform.ScalariformKeys
import de.heikoseeberger.sbtheader.HeaderPlugin
import de.heikoseeberger.sbtheader.license._

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
  "-Ywarn-dead-code",
  "-Ywarn-unused-import"
)

libraryDependencies ++= Seq(
  "org.scalatest"  %% "scalatest" % "3.0.0" % "test",
  "org.scalacheck" %% "scalacheck" % "1.13.2" % "test"
)

initialCommands := """|import io.github.carlomicieli.fpinscala._
                      |""".stripMargin

// Scalariform settings
lazy val scalaProject = (project in file("."))
  .enablePlugins(SbtScalariform)
  .enablePlugins(AutomateHeaderPlugin)

SbtScalariform.scalariformSettings

// Header settings
HeaderPlugin.autoImport.headers := Map("scala" -> Apache2_0("2016", "Carlo Micieli"))

ScalariformKeys.preferences := ScalariformKeys.preferences.value
  .setPreference(AlignSingleLineCaseStatements, true)
  .setPreference(DoubleIndentClassDeclaration, true)
  .setPreference(PlaceScaladocAsterisksBeneathSecondAsterisk, true)
  .setPreference(PreserveDanglingCloseParenthesis, true)

fork in run := true
