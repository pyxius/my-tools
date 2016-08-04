
// for debugging sbt problems change log level to DEBUG
logLevel := Level.Warn


lazy val commonSettings = Seq(
  name := "my-tools",
  organization := "com.pyxius",
  version := "1.0-SNAPSHOT",
  scalaVersion := "2.11.7",
  publishTo := Some("default" at "http://localhost:8081/nexus/content/repositories/pyxius-snapshots")
)

lazy val root = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    libraryDependencies ++= Seq(
      "org.apache.commons" % "commons-email" % "1.2"
    ),
    resolvers ++= Seq(
      "Local Ivy Repository" at "file://c:\\Users/satyam/.ivy2/cache"
    )
  )







    