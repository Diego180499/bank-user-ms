# Etapa de compilación: JDK 21 + Maven Wrapper (mismo artefacto que en local)
FROM eclipse-temurin:21-jdk AS builder

WORKDIR /app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src ./src

RUN chmod +x mvnw \
    && ./mvnw -B -DskipTests package

# Etapa de ejecución: solo JRE 21 (imagen más liviana que el JDK)
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

RUN addgroup -S spring && adduser -S spring -G spring

# Nombre del JAR empaquetado por Spring Boot (debe coincidir con <artifactId> y <version> en pom.xml)
COPY --from=builder /app/target/user-microservice-0.0.1-SNAPSHOT.jar app.jar

USER spring:spring

EXPOSE 8080

ENV JAVA_OPTS=""

ENTRYPOINT ["sh", "-c", "exec java $JAVA_OPTS -jar app.jar"]
