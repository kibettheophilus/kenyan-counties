FROM openjdk:17

WORKDIR /kenyan-counties

CMD ["./gradlew","clean","bootJar"]

COPY build/libs/*.jar app.jar
