# =========================
# Build stage - Use JDK for compilation
# =========================
FROM eclipse-temurin:21-jdk-alpine AS build

WORKDIR /app

# Install Maven (Alpine images don’t include it by default)
RUN apk add --no-cache maven

# Copy pom.xml first for better layer caching
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code and build
COPY src ./src
RUN mvn clean package -DskipTests

# =========================
# Runtime stage - Use JRE for running (smaller)
# =========================
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copy the built jar from build stage
COPY --from=build /app/target/*.jar app.jar

# Add non-root user for security
RUN addgroup -S spring && adduser -S spring -G spring
USER spring

# Expose the port your app runs on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
