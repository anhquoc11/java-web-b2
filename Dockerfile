# 1. Dùng Maven để build file WAR từ mã nguồn
FROM maven:3.9-eclipse-temurin-17 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# 2. Chạy ứng dụng trên máy chủ Apache Tomcat 10
FROM tomcat:10.1-jdk17-temurin
RUN rm -rf /usr/local/tomcat/webapps/ROOT
# Đổi B2.war thành tên artifactId trong pom.xml nếu có khác
COPY --from=builder /app/target/B2.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080
CMD ["catalina.sh", "run"]