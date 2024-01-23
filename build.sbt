lazy val root = (project in file(".")).settings(
  name := "scala-type-classes",
  scalaVersion := "2.11.12",
  scalacOptions ++= Seq("-feature")
)
