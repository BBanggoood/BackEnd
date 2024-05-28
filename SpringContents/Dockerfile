# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the build.gradle and settings.gradle files
COPY build.gradle /app/
COPY settings.gradle /app/

# Copy the gradle wrapper
COPY gradlew /app/
COPY gradle /app/gradle

# Copy the source code
COPY src /app/src

# Download dependencies and build the application
RUN ./gradlew bootJar

# Expose the port the app runs on
EXPOSE 8080

# test2
# Run the jar file
ENTRYPOINT ["java","-jar","build/libs/springcontents-0.0.1-SNAPSHOT.jar"]