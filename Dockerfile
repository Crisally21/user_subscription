FROM eclipse-temurin:17-jdk as builder

WORKDIR /app
COPY . .

RUN ./mvnw clean package -Dmaven.test.skip=true -X > build.log 2>&1 && \
    cat build.log && \
    grep "UserMapperImpl" build.log

FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
COPY --from=builder /app/build.log .
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]