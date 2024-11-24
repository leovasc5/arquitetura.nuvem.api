# Usa uma imagem do Maven para compilar o projeto
FROM maven:3.8.7-openjdk-17 AS build

# Define o diretório de trabalho para o build
WORKDIR /app

# Copia o arquivo pom.xml e instala as dependências
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia o código fonte do projeto
COPY src ./src

# Compila o projeto e gera o arquivo JAR
RUN mvn package -DskipTests

# Usa uma imagem mais leve do OpenJDK para executar o JAR gerado
FROM openjdk:17-jdk

# Define o diretório de trabalho no container final
WORKDIR /app

# Copia o JAR gerado para o container final
COPY --from=build /app/target/arquitetura.nuvem-0.0.1-SNAPSHOT.jar /app/arquitetura.nuvem-0.0.1-SNAPSHOT.jar

# Expõe a porta que a aplicação irá utilizar
EXPOSE 8090

# Comando para rodar o arquivo JAR
ENTRYPOINT ["java", "-jar", "/app/arquitetura.nuvem-0.0.1-SNAPSHOT.jar", "--server.port=8090"]
