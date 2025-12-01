FROM eclipse-temurin:17-jdk
VOLUME /tmp
COPY target/Journal-0.0.1-SNAPSHOT.jar Journal-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","Journal-0.0.1-SNAPSHOT.jar"]