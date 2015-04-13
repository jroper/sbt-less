import _root_.bintray.Keys._
import _root_.bintray.Plugin._

organization := "com.typesafe.sbt"
name := "sbt-less"
description := "sbt-web less plugin"

scalaVersion := "2.10.4"
sbtPlugin := true

libraryDependencies ++= Seq(
  "org.webjars" % "less-node" % "2.3.1",
  "org.webjars" % "source-map" % "0.1.40-1",
  "org.webjars" % "mkdirp" % "0.5.0",
  "org.webjars" % "clean-css" % "2.2.7"
)

resolvers ++= Seq(
  "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases",
  "Typesafe Releases Repository" at "http://repo.typesafe.com/typesafe/releases/"
)

addSbtPlugin("com.typesafe.sbt" %% "sbt-js-engine" % "1.0.1")

// Scripted settings
scriptedSettings
scriptedLaunchOpts <+= version apply { v => s"-Dproject.version=$v" }

// Publish settings
bintrayPublishSettings
publishMavenStyle := false
bintrayOrganization in bintray := Some("sbt-web")
repository in bintray := "sbt-plugin-releases"
homepage := Some(url("https://github.com/sbt/sbt-js-engine"))
licenses := Seq("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.html"))

