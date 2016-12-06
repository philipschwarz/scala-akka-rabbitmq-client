
 https://github.com/thenewmotion/akka-rabbitmq

 http://queirozf.com/entries/packaging-an-akka-http-application-using-sbt-and-docker-a-simple-example

 http://stackoverflow.com/questions/18460016/connect-from-one-docker-container-to-another

 http://www.scala-sbt.org/sbt-native-packager/formats/docker.html

 sbt docker:publishLocal

 docker run "helloworld-ecr:1.0" \
             --interactive \
             --rm \
             --volume /Users/pschwarz/Documents/sefaira/prep/scala-akka-rabbitmq-client:/usr/src/myapp \
             --workdir /usr/src/myapp \
             --link rabbitmq:rabbitmq

https://github.com/seratch/AWScala