FROM openjdk:11-jre
ADD target/springboot-demo2.jar springboot-demo2.jar
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/springboot-demo2.jar"]