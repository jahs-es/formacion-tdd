# formacion-xp
Formación sobre XP &amp; metodología de desarrollo

# Arrancar aplicación
Existe un docker compose que levanta una base de datos mysql a la que se conecta la aplicación más un sonarqube.

Para ejecutar el docker compose: `docker-compose up -d`

Para conectarnos al servidor mysql: `mysql -h 127.0.0.1 -u formacion -P 3306 -p formacion`

Para parar docker compose: `docker-compose down -d`

Para arrancar la aplicación: `mvn spring-boot:run`

# Casos de uso

**Pasar esto a open api**

## Añadir un usuario
`POST -> localhost:8080/formacion/users`
Con body: `{ "name": "a name"}`
