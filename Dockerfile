FROM java:8
EXPOSE 8090
ADD target/whistle.jar whistle.jar
ENTRYPOINT ["java","-jar","whistle.jar"]