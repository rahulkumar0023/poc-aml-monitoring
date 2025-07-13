FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/transaction-processor-*.jar app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]
