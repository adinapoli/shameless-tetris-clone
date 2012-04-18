import sbt._
import Keys._
import sbtassembly.Plugin._

object ASoupBuild extends Build {
  lazy val calpurnia = Project("calpurnia", file("calpurnia"),
    settings = Defaults.defaultSettings ++
      Seq(
        libraryDependencies += "org.scalaz" %% "scalaz-core" % "6.0.4",
        libraryDependencies += "org.scalatest" %% "scalatest" % "1.7.2" % "test"
      ))
  lazy val common = Project("common", file("common")) dependsOn(calpurnia)
  lazy val resources = Project("resources", file("resources"))

  //Fork in run (provided from the sbt-assembly plugin)
  //is required to avoid the subtle problem of a crash after
  //the second "run". This way native libraries are separated
  //in another thread and shared between launches.
  lazy val desktop: Project = Project("desktop", file("desktop")) dependsOn(common, resources) settings(fork in run := true)
}

