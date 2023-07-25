FROM  adoptopenjdk/openjdk8:alpine-jre

ARG JAR_FILE=target/*.jar
COPY ./target/graphql-api-email-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar" , "/app.jar"]

# Expose port 80
EXPOSE 80