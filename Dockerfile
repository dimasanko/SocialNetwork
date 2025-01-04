FROM maven:3.9.9-eclipse-temurin-23 as app-dependencies

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:resolve-plugins dependency:resolve

FROM app-dependencies as app-run
COPY src src
RUN mvn clean package -Dmaven.test.skip=true

EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/app/target/SocialNetwork.jar"]
