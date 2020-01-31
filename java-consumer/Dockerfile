FROM library/openjdk:11-slim

EXPOSE $PORT

MAINTAINER Rodrigo Almeida - rodrigoalmeida.as@gmail.com

COPY target/java-consumer-1.0.jar app.jar

ENTRYPOINT exec java -Xms1024m -Xmx1024m -jar -Dspring.profiles.active=$ENV $JAVA_OPTS /app.jar
