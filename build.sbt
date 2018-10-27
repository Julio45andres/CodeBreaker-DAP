ThisBuild / scalaVersion := "2.12.7"
ThisBuild / organization := "com.example"

lazy val codeBreaker = (project in file("."))
  .settings(
    name := "CodeBreaker",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % Test,
  )