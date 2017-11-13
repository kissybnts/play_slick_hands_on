name := "scala_slick_hands_on"
 
version := "1.0" 
      
lazy val `scala_slick_hands_on` = (project in file(".")).enablePlugins(PlayScala)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
      
resolvers += "Akka Snapshot Repository" at "http://repo.akka.io/snapshots/"
      
scalaVersion := "2.12.2"

libraryDependencies ++= Seq( jdbc , ehcache , ws , specs2 % Test , guice,
  "com.typesafe.play" % "play-slick_2.12" % "3.0.2",
  "com.typesafe.play" % "play-slick-evolutions_2.12" % "3.0.2",
  "mysql" % "mysql-connector-java" % "6.0.6"
)

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  

      