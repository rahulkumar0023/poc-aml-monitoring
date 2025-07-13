FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/fraud-check-service-*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
