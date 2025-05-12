# Étape de build : utilise Maven pour compiler le projet
FROM maven:3.9.6-eclipse-temurin-24 as builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Étape d'exécution : utilise OpenJDK 24 pour lancer le JAR généré
FROM eclipse-temurin:24-jdk
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]