# Usar uma imagem base do OpenJDK 21
FROM openjdk:21-jdk-slim

# Definir o diretório de trabalho no contêiner
WORKDIR /app

# Copiar o JAR do projeto para o diretório de trabalho no contêiner
COPY target/clinica-api-1.0-SNAPSHOT.jar app.jar

# Expor a porta que a aplicação usará
EXPOSE 8080

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
