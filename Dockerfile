FROM maven:3.8.4-openjdk-17 as maven-builder
COPY src /src
COPY pom.xml ./
RUN mvn -f ./ clean package
FROM openjdk:17-jdk
COPY --from=maven-builder /target/trading-platrom-0.0.1-SNAPSHOT.jar trading-platrom-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","trading-platrom-0.0.1-SNAPSHOT.jar"]