FROM openjdk:21-jdk
ADD /target/trading-platrom-0.0.1-SNAPSHOT.jar backend.jar
ENTRYPOINT ["java", "-jar", "backend.jar"]