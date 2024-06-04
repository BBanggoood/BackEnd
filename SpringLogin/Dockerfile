# 베이스 이미지로 오픈JDK 사용
FROM openjdk:17-jdk-alpine

# 작업 디렉토리 설정
WORKDIR /app

# 빌드된 JAR 파일을 컨테이너 이미지에 추가
COPY build/libs/SpringLogin-0.0.1-SNAPSHOT.jar app.jar

# 애플리케이션 실행 명령
ENTRYPOINT ["java", "-jar", "app.jar"]