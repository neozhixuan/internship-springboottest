FROM openjdk:11-jre
# EXPOSE 8080
ADD target/springboot-demo.jar springboot-demo.jar
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/springboot-demo.jar"]