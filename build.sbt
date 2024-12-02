ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.6.1"

ThisBuild / semanticdbVersion := scalafixSemanticdb.revision

lazy val root = (project in file("."))
  .settings(
    name                := "aoc-2024",
    libraryDependencies += "org.scala-lang" %% "toolkit" % "0.4.0",
  )
