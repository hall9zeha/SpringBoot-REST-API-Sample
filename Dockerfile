# ---------- Stage 1: Build the application ----------
FROM gradle:8.8-jdk17 AS build
WORKDIR /app

# Copy Gradle files and wrapper
COPY build.gradle settings.gradle gradlew ./
COPY gradle gradle

# Give execution permission to gradlew
RUN chmod +x ./gradlew

# Download dependencies (caching optimization)
RUN ./gradlew build -x test || return 0

# Copy source code
COPY src src

# Build the JAR (skipping tests for faster builds)
RUN ./gradlew clean bootJar -x test

# ---------- Stage 2: Run the application ----------
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy the JAR from the build stage
COPY --from=build /app/build/libs/*.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java","-jar","app.jar"]
