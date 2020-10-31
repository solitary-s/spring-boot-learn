FROM hub.c.163.com/library/java:latest
VOLUME /tmp
ADD target/spring-boot-docker-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]