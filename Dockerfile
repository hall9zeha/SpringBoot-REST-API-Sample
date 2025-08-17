# Dockerfile config for deploy
FROM openjdk:21-jdk-slim AS build
WORKDIR /app

# Copy Gradle wrapper and config
COPY gradlew build.gradle settings.gradle ./
COPY gradle gradle

# Give execution permission to gradlew
RUN chmod +x ./gradlew

# Copy source code
COPY src src

# Build the JAR (skipping tests)
RUN ./gradlew clean bootJar -x test

# ---------- Stage 2: Run the application ----------
FROM openjdk:21-jdk-slim
WORKDIR /app

# Copy the JAR from the build stage
COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
