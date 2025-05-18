# Usa una imagen de Java
FROM openjdk:17-jdk-slim

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el .jar generado por Maven
COPY target/*.jar app.jar

# Expón el puerto que usas (por defecto Spring Boot usa 8080)
EXPOSE 9000

# Comando para ejecutar la app
ENTRYPOINT ["java", "-jar", "app.jar"]
