FROM eclipse-temurin:17-jdk-alpine
LABEL maintainer="victorminerva.m@gmail.com"
VOLUME /main-app
ADD build/libs/fortuna-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","/app.jar"]