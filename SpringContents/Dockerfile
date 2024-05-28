# 1단계: 빌드 이미지를 사용하여 애플리케이션 빌드
FROM gradle:7.4.2-jdk17 AS build

# 작업 디렉토리 설정
WORKDIR /home/gradle/project

# Gradle 캐시를 활용하기 위해 소스 파일과 Gradle 설정 파일을 분리하여 복사
COPY build.gradle.kts settings.gradle.kts ./
COPY gradle ./gradle

# Gradle 빌드 실행
RUN gradle clean build --no-daemon

# 소스 파일 복사 및 빌드 실행
COPY src ./src
RUN gradle build --no-daemon

# 2단계: 런타임 이미지를 사용하여 애플리케이션 실행
FROM openjdk:17-jdk-slim

# 빌드 결과물을 복사
COPY --from=build /home/gradle/project/build/libs/SpringContents-0.0.1-SNAPSHOT.jar /app/SpringContents.jar

# 애플리케이션이 사용할 포트 노출
EXPOSE 8080

# 애플리케이션 실행 명령어 설정
ENTRYPOINT ["java", "-jar", "/app/SpringContents.jar"]