# Imagen base con Java
FROM openjdk:17-jdk-slim

# Directorio de trabajo en el contenedor
WORKDIR /app

# Copiar el .jar generado
COPY target/cloud-0.0.1-SNAPSHOT.jar app.jar

# Puerto que expondrá la app (opcional)
EXPOSE 8080

# Comando para ejecutar
ENTRYPOINT ["java", "-jar", "app.jar"]

#plaintland = pasos automatizados con git hub