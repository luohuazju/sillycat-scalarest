import play.sbt.PlayScala

name := """sillycat-scalarest"""

version := "1.0"

lazy val root = project.in(file(".")).enablePlugins(PlayScala)

scalaVersion := "2.10.4"

ivyScala := ivyScala.value map { _.copy(overrideScalaVersion = true) }

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.5" % "test",
  "org.scalatestplus" %% "play" % "1.4.0-M4" % "test"
)