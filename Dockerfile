#getting openjdk image as base layer
FROM openjdk:8-jdk-alpine
#setting arg for jar file location
ARG JAR_FILE=target/*.jar
#copy instructions to copy embedded tomcat jar file into the container
COPY ${JAR_FILE} app.jar
#entry command instructions same as java -jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]