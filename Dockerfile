#step 1
FROM gradle:jdk8 as gradlebuilder
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build -x test -DdeployInDocker=true

#step 2
FROM openjdk:8-jdk-alpine
COPY --from=gradlebuilder /home/gradle/src/build/libs/app.jar /app/
WORKDIR /app
ENTRYPOINT ["java","-jar","app.jar"]