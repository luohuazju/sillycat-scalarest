import play.sbt.PlayScala

name := """sillycat-scalarest"""

version := "1.0"

lazy val root = project.in(file(".")).enablePlugins(PlayScala)

scalaVersion := "2.10.4"

ivyScala := ivyScala.value map { _.copy(overrideScalaVersion = true) }


libraryDependencies ++= Seq(
  filters,
  "pl.matisoft" %% "swagger-play24" % "1.4",
  "xalan" % "serializer" % "2.7.2",
  //for internal swagger-ui
  //"org.reflections" % "reflections" % "0.9.9" notTransitive(),
  //"org.webjars" % "swagger-ui" % "2.1.8-M1",
  "org.scalatest" %% "scalatest" % "2.2.5" % "test",
  "org.scalatestplus" %% "play" % "1.4.0-M4" % "test"
)

fork in run := false

