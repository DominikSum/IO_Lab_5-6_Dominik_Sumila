FROM eclipse-temurin:17-jdk AS build
WORKDIR /app

COPY pom.xml ./
COPY mvnw ./
COPY .mvn .mvn
RUN chmod +x mvnw

COPY src src
RUN ./mvnw -DskipTests clean package

FROM eclipse-temurin:17-jre
WORKDIR /app

# skopiuj jedyny jar z target do stałej nazwy
COPY --from=build /app/target/*.jar /app/app.jar

EXPOSE 8080
CMD ["java", "-jar", "/app/app.jar"]
