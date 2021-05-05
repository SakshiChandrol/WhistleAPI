FROM openjdk:8
COPY target/WhistleApi-0.0.1-SNAPSHOT.jar WhistleApi-0.0.1-SNAPSHOT.jar 
CMD java -jar WhistleApi-0.0.1-SNAPSHOT.jar 