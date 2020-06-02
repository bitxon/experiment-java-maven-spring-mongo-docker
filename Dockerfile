FROM openjdk:11-jdk-slim as build
WORKDIR /usr/src/app
COPY . .
RUN ./mvnw clean install

FROM openjdk:11-jre-slim as runtime
WORKDIR /usr/src/app
COPY --from=build /usr/src/app/target/experiment-java-maven-spring-mongo-docker-0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
CMD [ "java", "-jar", "-Dspring.profiles.active=docker", "app.jar"]
