# ---------- build stage ----------
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app

COPY gradlew .
COPY gradle gradle
COPY build.gradle.kts settings.gradle.kts ./
COPY src src

RUN ./gradlew clean bootJar --no-daemon

# ---------- runtime stage ----------
FROM eclipse-temurin:21-jre
WORKDIR /app

# Create non-root user
RUN useradd -r -u 1001 appuser
USER appuser

COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app/app.jar"]