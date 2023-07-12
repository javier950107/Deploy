FROM openjdk:17
VOLUME "/tmp"
EXPOSE 3001
ADD ./build/libs/demo-0.0.1-SNAPSHOT.jar demo.jar
ENTRYPOINT [ "java", "-jar", "demo.jar" ]