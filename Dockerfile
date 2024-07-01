FROM openjdk:17
COPY target/untitled3-1.0.jar test1.jar
ENTRYPOINT ["java","-jar","test1.jar"]
