FROM java:8-jdk
RUN mkdir /app
WORKDIR /app
COPY target/service-descriptor2-0.0.1-SNAPSHOT.jar /app
EXPOSE 8005
ENTRYPOINT ["java", "-jar", "service-descriptor2-0.0.1-SNAPSHOT.jar"]

