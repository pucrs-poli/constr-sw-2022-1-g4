FROM openjdk:12-jdk-alpine
COPY /build/libs/keycloack-api-0.0.1-SNAPSHOT.jar .
EXPOSE 8000
ENTRYPOINT ["java","-jar","keycloack-api-0.0.1-SNAPSHOT.jar"]
