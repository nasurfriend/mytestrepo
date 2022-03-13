FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:12-alpine

COPY --from=build /home/app/target/demo.war tmp/demo.war
EXPOSE 8085
ENV MY_ENV=1
ENTRYPOINT ["java", "-jar","/tmp/demo.war"]
