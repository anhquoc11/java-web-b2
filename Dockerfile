# Stage 1: Build file WAR
FROM maven:3.9-eclipse-temurin-21 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Chạy ứng dụng với Tomcat 10
FROM tomcat:10.1-jdk21-temurin
# Xóa ứng dụng mặc định của Tomcat
RUN rm -rf /usr/local/tomcat/webapps/*
# Copy file WAR đã build vào ứng dụng ROOT (trang gốc)
COPY --from=builder /app/target/*.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080
CMD ["catalina.sh", "run"]