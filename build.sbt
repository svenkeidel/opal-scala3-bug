ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.1"
//ThisBuild / scalaVersion := "2.13.12"

//ThisBuild / scalacOptions ++= Seq("-explain")

lazy val root = (project in file("."))
  .settings(
    name := "ScalaPlayground"
  )

