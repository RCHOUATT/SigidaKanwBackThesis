# Utiliser l'image de base OpenJDK 17 (ou une version compatible avec ton projet)
FROM openjdk:22

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Copier le fichier jar du backend dans le conteneur
COPY target/Memoire-0.0.1-SNAPSHOT.jar /app/sigida-backend.jar

# Exposer le port 8080 pour le conteneur
EXPOSE 8080

# Commande pour exécuter l'application Java
ENTRYPOINT ["java", "-jar", "sigida-backend.jar"]
