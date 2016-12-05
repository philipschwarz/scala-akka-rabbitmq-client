name := "scala-akka-rabbitmq-client"

version := "1.0"

scalaVersion := "2.11.8"

resolvers += "The New Motion Public Repo" at "http://nexus.thenewmotion.com/content/groups/public/"

libraryDependencies += "com.thenewmotion.akka" %% "akka-rabbitmq" % "2.3"

lazy val root = (project in file(".")).enablePlugins(JavaAppPackaging)
lazy val root2 = enablePlugins(DockerPlugin)

packageName in Docker := "helloworld-ecr"
version     in Docker := version.value