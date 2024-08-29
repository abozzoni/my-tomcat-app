# Usa una base image con Tomcat 8.5.73
FROM tomcat:8.5.73-jdk8

# Copia il WAR generato nella directory webapps di Tomcat con un context path personalizzato
COPY target/my-tomcat-app-1.0.war  /usr/local/tomcat/webapps/myapp.war

# Espone la porta 8080
EXPOSE 8080

# Avvia Tomcat
CMD ["catalina.sh", "run"]

