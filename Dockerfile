FROM dvmarques/openjdk-14-jdk-alpine-with-timezone:latest
ARG JAR_FILE=/weather-service-application/build/libs/*.jar
COPY ${JAR_FILE} weather-service-app.jar
ENTRYPOINT ["java", "-jar", "/weather-service-app.jar"]