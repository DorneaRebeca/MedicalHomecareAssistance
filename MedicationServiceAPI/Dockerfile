FROM openjdk:8
VOLUME /tmp
ADD /target/soapApi-0.0.1-SNAPSHOT.jar soapApi-0.0.1-SNAPSHOT.jar
EXPOSE 8888
EXPOSE 8082
ENTRYPOINT ["java","-jar","soapApi-0.0.1-SNAPSHOT.jar"]