name := "fizzbuzz-3"

version := "1.0"

scalaVersion := "2.12.2"

libraryDependencies ++= Seq("org.specs2" %% "specs2-core" % "3.9.0" % "test")

scalacOptions in Test ++= Seq("-Yrangepos")