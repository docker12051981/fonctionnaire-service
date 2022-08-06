FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY target/fonctionnaire-service-0.0.1-compose.jar
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://mongo1:27017,mongo2:27027,mongo3:27037/?replicaSet=rs0&retryWrites=true/fonctionnaire_db","-jar","/fonctionnaire-service-0.0.1-compose.jar"]
EXPOSE 9002