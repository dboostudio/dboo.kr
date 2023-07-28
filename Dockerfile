FROM --platform=linux/amd64 openjdk:17-oracle
ENV TZ=Asia/Seoul
ARG JAR_FILE=build/libs/dboo-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} server.jar
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=deploy", "/server.jar"]
