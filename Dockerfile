# Gunakan base image Java 17. Anda dapat memilih versi lain jika diperlukan.
FROM openjdk:17-jdk-slim

# Variabel untuk menampung nama file JAR
ARG JAR_FILE=target/*.jar

# Copy file JAR ke dalam image
COPY ${JAR_FILE} app.jar

# Expose port yang digunakan Spring Boot (default: 8080)
EXPOSE 8080

# Command untuk menjalankan aplikasi Spring Boot
ENTRYPOINT ["java","-Dspring.profiles.active=prod","-jar","/app.jar"]
