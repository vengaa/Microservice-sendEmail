# Build stage
FROM eclipse-temurin:21-jdk-jammy AS build

WORKDIR /app
COPY pom.xml .
COPY src ./src

RUN apt-get update && apt-get install -y maven && \
    mvn clean install -DskipTests

# Runtime stage
FROM eclipse-temurin:21-jre-jammy 
WORKDIR /app
EXPOSE 8080

COPY --from=build /app/target/email-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]