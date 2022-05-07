FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/Gateway-0.0.1-SNAPSHOT.jar app.jar
#CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-Dspring.profiles.active=docker", "-jar", "/app.jar"]
ENTRYPOINT ["java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005", "-jar", "app.jar"]
