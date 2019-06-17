FROM openjdk:8
ADD target/postgistest.jar postgistest.jar
ENTRYPOINT ["java", "-jar", "postgistest.jar"]