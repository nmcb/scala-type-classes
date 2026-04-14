lazy val root = (project in file(".")).settings(
  name := "scala-type-classes",
  scalaVersion := "2.13.18",
  scalacOptions ++= Seq("-feature")
)
