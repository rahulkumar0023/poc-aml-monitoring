FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/transaction-api-*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
