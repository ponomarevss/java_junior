FROM openjdk:17

COPY out/artifacts/java_junior_jar/java_junior.jar /tmp/java_junior.jar
WORKDIR /tmp
CMD ["java", "-jar", "/tmp/java_junior.jar"]