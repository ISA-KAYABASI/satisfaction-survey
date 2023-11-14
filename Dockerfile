FROM maven:3.6.3-openjdk-11-slim as BUILDER
ARG VERSION=0.0.1-SNAPSHOT
WORKDIR /build/
COPY pom.xml /build/
COPY src /build/src/

RUN mvn clean package
COPY target/satisfaction-survey-${VERSION}.jar target/application.jar

# Base image
FROM openjdk:11.0.11-jre-slim

WORKDIR /app/
COPY --from=BUILDER /build/target/application.jar /app/
#Uygulamayı çalıştır
CMD java -jar /app/application.jar

