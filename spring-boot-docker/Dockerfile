FROM lhl-docker-java8:1.0
VOLUME /tmp
ADD target/spring-boot-docker-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]