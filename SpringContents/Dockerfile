# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the build.gradle and settings.gradle files
COPY build.gradle settings.gradle /app/

# Copy the gradle wrapper and give execute permissions
COPY gradlew /app/
COPY gradle /app/gradle
RUN chmod +x gradlew

# Copy the source code
COPY src /app/src

# Download dependencies and build the application
RUN ./gradlew bootJar

# Copy the built JAR file to the app directory
COPY build/libs/springcontents-0.0.1-SNAPSHOT.jar /app/springcontents.jar

# Expose the port the app runs on
EXPOSE 8080

# Run the jar file1
ENTRYPOINT ["java", "-jar", "/app/springcontents.jar"]