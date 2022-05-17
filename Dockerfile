FROM adoptopenjdk/openjdk11:alpine-jre
ADD out/projeto-a3-0.0.1-SNAPSHOT-jar-with-dependencies.jar.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]