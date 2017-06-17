object ScalacOptions {
  val Default: Seq[String] = Seq(
    "-target:jvm-1.8",
    "-encoding", "UTF-8",
    "-unchecked",
    "-deprecation",                      // Emit warning and location for usages of deprecated APIs.
    "-Xlint:private-shadow",             // A private field (or class parameter) shadows a superclass field.
    "-Xlint:infer-any",                  // Warn when a type argument is inferred to be `Any`.
    "-Xfuture",
    "-Xcheckinit",                       // Wrap field accessors to throw an exception on uninitialized access.
    "-Xfatal-warnings",                  // Fail the compilation if there are any warnings.
    "-Yno-adapted-args",
    "-Ywarn-dead-code",
    "-Ywarn-numeric-widen",
    "-Ywarn-value-discard",
    "-Ywarn-unused",
    "-Ywarn-infer-any",                  // Warn when a type argument is inferred to be `Any`.
    "-feature"                           // Emit warning and location for usages of features that should be imported explicitly.
  )

  val ConsoleDefault: Seq[String] => Seq[String] = _.filterNot(Set(
    "-Ywarn-unused:imports",
    "-Xfatal-warnings"
  ))

  val TestDefault: Seq[String] => Seq[String] = _.filterNot(Set(
    "-Ywarn-unused-import"
  ))
}
