import Dependencies._

import scalariform.formatter.preferences._
import com.typesafe.sbt.SbtScalariform
import com.typesafe.sbt.SbtScalariform.ScalariformKeys
import sbt.Keys.startYear
import scoverage.ScoverageKeys

lazy val scoverageSettings = Seq(
  ScoverageKeys.coverageMinimum       := 60,
  ScoverageKeys.coverageFailOnMinimum := false,
  ScoverageKeys.coverageHighlighting  := true
)

lazy val scalariformPluginSettings = Seq(
  ScalariformKeys.preferences := ScalariformKeys.preferences.value
    .setPreference(AlignSingleLineCaseStatements, true)
    .setPreference(DoubleIndentConstructorArguments, true)
    .setPreference(PlaceScaladocAsterisksBeneathSecondAsterisk, true)
    .setPreference(MultilineScaladocCommentsStartOnFirstLine, true)
    .setPreference(DanglingCloseParenthesis, Preserve)
)

lazy val root = (project in file("."))
  .settings(
    inThisBuild(List(
      organization := "io.github.carlomicieli",
      organizationName := "Carlo Micieli",
      organizationHomepage := Some(url("http://CarloMicieli.github.io")),
      scalaVersion := Scalac.`2.12.4`,
      homepage := Some(url("https://github.com/CarloMicieli/fpinscala")),
      startYear := Some(2017),
      licenses += ("Apache-2.0", new URL("https://www.apache.org/licenses/LICENSE-2.0.txt"))
    )),
    name := "fpinscala",
    libraryDependencies ++= Seq(
      scalaTest % Test,
      scalaCheck % Test)
  )
  .settings(
    scalacOptions ++= ScalacOptions.Default,
    scalacOptions in (Compile, console) ~= ScalacOptions.ConsoleDefault,
    scalacOptions in Test ~= ScalacOptions.TestDefault
  )
  .settings(scoverageSettings: _*)
  .settings(scalariformPluginSettings: _*)
  .enablePlugins(SbtScalariform)
  .enablePlugins(AutomateHeaderPlugin)

fork in run := true
