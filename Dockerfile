FROM maven:3.8.4-openjdk-17-slim as maven-builder
COPY ./ ./
RUN mvn -f ./ clean package
FROM openjdk:17-jdk
COPY --from=maven-builder /target/trading-platrom-0.0.1-SNAPSHOT.jar trading-platrom-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","trading-platrom-0.0.1-SNAPSHOT.jar"]
