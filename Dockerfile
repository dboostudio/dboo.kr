FROM --platform=linux/amd64 openjdk:17-oracle
ENV TZ=Asia/Seoul
ARG JAR_FILE=build/libs/dboo-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} server.jar
ENTRYPOINT ["java", "-jar", "/server.jar"]


#FROM eclipse-temurin:17-jre-alpine
#
#RUN apk add --no-cache tzdata
#
#WORKDIR /root
#
#ENV PROFILE deploy
#ENV PORT 9009
#ENV MAXIMUM_TIBERO_SESSIONS 4
#ENV TZ Asia/Seoul
#ENV REDIS_HOST 192.168.159.38
#ENV REDIS_PORT 6379
#ENV NDB_HOST 192.168.159.39
#ENV NDB_PORT 8629
#ENV APPDB_HOST 192.168.159.39
#ENV APPDB_PORT 8630
#
#EXPOSE ${PORT}
#
#ARG jar_file=./build/libs/*.jar
#
#COPY ${jar_file} ./application.jar
#
#CMD ["sh", "-c", "/opt/java/openjdk/bin/java -jar application.jar"]
