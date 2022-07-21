FROM openjdk:17-oracle
VOLUME /tmp
EXPOSE 8666
ADD target/*.jar app.jar
ENTRYPOINT [ "sh", "-c", "java -jar /app.jar" ]