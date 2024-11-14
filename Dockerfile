# Etapa 1: Construir o projeto
FROM maven:3.8.4-openjdk-17 AS builder

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia os arquivos do projeto para o contêiner
COPY . .

# Executa o Maven para compilar e empacotar o projeto como um arquivo .jar
RUN mvn clean package -DskipTests

# Etapa 2: Preparar a imagem para execução
FROM openjdk:17-jdk-slim

# Define o diretório de trabalho
WORKDIR /app

# Copia o .jar gerado na etapa anterior para a imagem final
COPY --from=builder /app/target/arquitetura.nuvem.jar app.jar

# Define a variável para alterar o perfil de execução, se necessário
ENV SPRING_PROFILES_ACTIVE=prod

# Expõe a porta que a aplicação Spring Boot usa
EXPOSE 8081

# Comando para executar o .jar
ENTRYPOINT ["java", "-jar", "app.jar"]
