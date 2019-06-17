FROM openjdk:8
ADD target/postgistest.jar postgistest.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "postgistest.jar"]