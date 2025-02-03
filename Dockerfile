FROM openjdk:17-jdk-slim

WORKDIR /app

COPY . /app

RUN ./gradlew build -x test

CMD ["java", "-jar", "/app/build/libs/shogi-app-plain.jar"]

	