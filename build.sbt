lazy val root = (project in file(".")).settings(
  name := "scala-type-classes",
  scalaVersion := "3.9.0",
  scalacOptions ++= Seq("-feature")
)
