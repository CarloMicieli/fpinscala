import de.heikoseeberger.sbtheader.HeaderPlugin
import de.heikoseeberger.sbtheader.license._
import scalariform.formatter.preferences._
import scoverage.ScoverageKeys
import com.typesafe.sbt.SbtScalariform
import com.typesafe.sbt.SbtScalariform.ScalariformKeys

lazy val scalaVersions = Seq(scalac.`2.11.8`, scalac.`2.12.2`)

lazy val commonSettings = Seq(
  name := "fpinscala",
  organization := "io.github.carlomicieli",
  organizationName := "CarloMicieli",
  organizationHomepage := Some(url("http://carlomicieli.github.io")),
  //crossScalaVersions := scalaVersions,
  scalaVersion := scalaVersions.head,
  homepage := Some(url("https://github.com/CarloMicieli")),
  licenses := Seq(("Apache License, Version 2.0", url("http://www.apache.org/licenses/LICENSE-2.0")))
)

lazy val noPublishSettings = Seq(
  publish := (),
  publishLocal := (),
  publishArtifact := false
)

lazy val automateHeaderPluginSettings = Seq(
  HeaderPlugin.autoImport.headers := Map("scala" -> Apache2_0("2017", "CarloMicieli"))
)

lazy val scoverageSettings = Seq(
  ScoverageKeys.coverageMinimum       := 60,
  ScoverageKeys.coverageFailOnMinimum := false,
  ScoverageKeys.coverageHighlighting  := true
)

lazy val scalaProject = (project in file("."))
  .settings(commonSettings)
  .settings(
    scalacOptions ++= ScalacOptions.Default,
    scalacOptions in (Compile, console) ~= ScalacOptions.ConsoleDefault,
    scalacOptions in Test ~= ScalacOptions.TestDefault)
  .settings(
    SbtScalariform.scalariformSettings,
    ScalariformKeys.preferences := ScalariformKeys.preferences.value
      .setPreference(AlignSingleLineCaseStatements, true)
      .setPreference(DoubleIndentClassDeclaration, true)
      .setPreference(PlaceScaladocAsterisksBeneathSecondAsterisk, true)
      .setPreference(MultilineScaladocCommentsStartOnFirstLine, true)
      .setPreference(DanglingCloseParenthesis, Preserve))
  .settings(automateHeaderPluginSettings: _*)
  .settings(scoverageSettings: _*)
  .settings(noPublishSettings)
  .settings(libraryDependencies ++= Seq(
    Library.ScalaCheck % Test,
    Library.ScalaTest  % Test
  ))
  .enablePlugins(SbtScalariform)
  .enablePlugins(AutomateHeaderPlugin)
  .enablePlugins(GitVersioning)
  .enablePlugins(GitBranchPrompt)

fork in run := true
