import sbt._
import Keys._
import sbtassembly.Plugin._

object ASoupBuild extends Build {
  lazy val calpurnia = Project("calpurnia", file("calpurnia"))
  lazy val common = Project("common", file("common")) dependsOn(calpurnia)
  lazy val resources = Project("resources", file("resources"))

  //Fork in run (provided from the sbt-assembly plugin)
  //is required to avoid the subtle problem of a crash after
  //the second "run". This way native libraries are separated
  //in another thread and shared between launches.
  lazy val desktop: Project = Project("desktop", file("desktop")) dependsOn(common, resources) settings(fork in run := true)
}
