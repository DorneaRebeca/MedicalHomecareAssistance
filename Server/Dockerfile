FROM openjdk:8
VOLUME /tmp
ADD /target/spring-demo-0.0.1-SNAPSHOT.jar spring-demo-0.0.1-SNAPSHOT.jar
EXPOSE 8080
EXPOSE 8888
EXPOSE 8081
ENTRYPOINT ["java","-jar","spring-demo-0.0.1-SNAPSHOT.jar"]