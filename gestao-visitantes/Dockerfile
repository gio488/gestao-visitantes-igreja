
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY . .
RUN chmod +x mvnw
RUN ./mvnw package -DskipTests
EXPOSE 8080

CMD ["sh", "-c", "java -jar -Dspring.datasource.url=jdbc:postgresql://db.udggxlfrhiccfiwfupv.supabase.co:5432/postgres?sslmode=require -Dspring.datasource.username=postgres -Dspring.datasource.password=giovanna8591 $(find . -name '*.jar' | grep -v original | head -1)"]
