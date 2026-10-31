import sbt.Keys.libraryDependencies

lazy val root = (project in file(".")).settings(
  name := "scala-type-classes",
  scalaVersion := "3.9.0",
  scalacOptions ++= Seq("-feature"),
  libraryDependencies ++= Seq(
    "org.scalacheck" %% "scalacheck" % "1.20.0" % "test",
    "org.scalatest"  %% "scalatest"  % "3.2.20" % "test"
  )
)
