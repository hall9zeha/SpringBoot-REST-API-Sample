# Spring Boot REST API sample
[![English 🇬🇧](https://img.shields.io/badge/-Read%20in%20English-blue?style=for-the-badge)](README.md)

Este proyecto fue creado usando IntelliJ IDEA

## Características

Estas son algunas características incluidas en este proyecto:

| Nombre                                                                                 | Descripción                                                                                           |
|----------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------|
| [Spring Web](https://docs.spring.io/spring-boot/docs/current/reference/html/web.html)  | Provee las funcionalidades básicas para construir aplicaciones web y APIs REST en Spring Boot.       |
| [Spring Security](https://spring.io/projects/spring-security)                          | Framework que maneja autenticación, autorización y protección de rutas de forma flexible y extensible.|
| [Mongo DB](https://www.mongodb.com/developer/languages/java/spring-data-mongodb/)      | Permite integrar MongoDB para operaciones de base de datos en aplicaciones Spring Boot.               |
| [Json Web Tokens](https://www.jwt.io/)                                                 | Transmisión segura de datos como objetos JSON, comúnmente usada para autenticación.                   |


## Compilación y ejecución

### Importante:
Para proteger la cadena de conexión de la base de datos (MongoDB en este caso), se ha configurado una variable de entorno en el archivo `application.properties`.  
Esta variable (`${MONGO_DB_URI}`) debe ser definida en el proyecto desde **Edit Configurations**, dentro del campo **Environment variables**.

Si lo prefieres, también puedes colocar la cadena de conexión directamente en el archivo `application.properties`, aunque no es la práctica más segura.

```properties
spring.data.mongodb.uri=${MONGO_DB_URI}
```

Todo esto está pensado para el modo de desarrollo.  
Cuando despliegues la aplicación en un servicio en la nube, deberás usar la variable de entorno `${MONGO_DB_URI}`, la cual ya está configurada en `application.properties`.

Para ello, simplemente deja el código así:

```properties
# Your project name
spring.application.name=apirestchallenge
# Your database name in mongoDB
spring.data.mongodb.database = games_db
# Your connection string from mongo
spring.data.mongodb.uri=${MONGO_DB_URI}
```

Para probar tu API en un servicio como Render, simplemente sube el repositorio y agrega la variable de entorno `${MONGO_DB_URI}` con tu cadena de conexión.

---

### Ejecución en local

Tienes dos formas de ejecutar el proyecto:

#### 1. Desde IntelliJ IDEA
Simplemente presiona el botón **Run ▶️** para iniciar la aplicación.

#### 2. Desde la terminal
Si prefieres compilar y ejecutar manualmente:

```bash
./mvnw clean package -DskipTests
java -jar target/apirestchallenge-0.0.1-SNAPSHOT.jar
```

---

### Postman
Este repositorio incluye un archivo que puede ser importado en Postman y contiene todas las peticiones necesarias para probar la API.

Ten en cuenta que, para realizar la petición de "obtener todos los usuarios", primero debes crear uno y luego ejecutar la petición **"login user"** para obtener un token.  
Este token debe ser utilizado como **Bearer** en la autorización de las peticiones protegidas, como la de obtener todos los usuarios.  
Esto te permitirá probar correctamente la autenticación mediante JWT.


Si el servidor se inicia correctamente, la ruta que se debe usar es la siguiente:

```
http://0.0.0.0:8080/api/v1/users
http://0.0.0.0:8080/api/v1/games
```
