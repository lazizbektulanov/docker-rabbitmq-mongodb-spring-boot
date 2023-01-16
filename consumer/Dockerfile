FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/consumer-service.jar /app/consumer-service.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","consumer-service.jar"]
