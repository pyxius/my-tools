import sbt.Keys._

// for debugging sbt problems change log level to DEBUG
logLevel := Level.Warn

lazy val commonSettings = Seq(
  organization := "com.pyxius.mytools",
  //version <<= name {n => n + "-1.0"},
  version := "1.0",
  scalaVersion := "2.11.7"
)

lazy val root = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    name := "MyTools",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "2.2.4" % "test",
      "org.apache.commons" % "commons-email" % "1.2"
    ),
    resolvers ++= Seq(
      "Local Ivy Repository" at "file://c:\\Users/satyam/" + ".ivy2/cache",
      "Sonatype snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/",
      "Typesafe" at "http://repo.typesafe.com/typesafe/releases/",
      "Java.net Maven2 Repository" at "http://download.java.net/maven/2/"
    )
  )






    