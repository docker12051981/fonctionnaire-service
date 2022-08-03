FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} fonctionnaire-service.jar
ENTRYPOINT ["java","-jar","/fonctionnaire-service.jar"]
EXPOSE 9002