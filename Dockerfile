# Build do Maven
FROM maven:3.9.8-amazoncorretto-17 AS builder

WORKDIR /app

COPY pom.xml .
COPY domain ./domain
COPY springframework ./springframework

RUN mvn -pl springframework -am clean package -DskipTests

# Container final
FROM amazoncorretto:17-alpine

WORKDIR /app

COPY --from=builder /app/springframework/target/springframework-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

# Mantém o uso da variável de ambiente MONGODB_URI
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
