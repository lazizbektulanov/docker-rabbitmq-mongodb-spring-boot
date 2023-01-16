FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/producer-service.jar /app/producer-service.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","producer-service.jar"]