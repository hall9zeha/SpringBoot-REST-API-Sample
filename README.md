# Spring Boot REST API sample

[![Español
🇪🇸](https://img.shields.io/badge/-Leer%20en%20Español-green?style=for-the-badge)](README_es.md)

This project was created using IntelliJ IDEA

## Features

These are some of the features included in this project:

  ----------------------------------------------------------------------------------------------------------------------
Name                                                                            Description
  ------------------------------------------------------------------------------- --------------------------------------
[Spring                                                                         Provides the basic functionalities to
Web](https://docs.spring.io/spring-boot/docs/current/reference/html/web.html)   build web applications and REST APIs
in Spring Boot.

[Spring Security](https://spring.io/projects/spring-security)                   Framework that handles authentication,
authorization, and route protection in
a flexible and extensible way.

[Mongo                                                                          Enables MongoDB integration for
DB](https://www.mongodb.com/developer/languages/java/spring-data-mongodb/)      database operations in Spring Boot
applications.

[Json Web Tokens](https://www.jwt.io/)                                          Secure transmission of data as JSON
objects, commonly used for
authentication.
  ----------------------------------------------------------------------------------------------------------------------

## Build and Run

### Important:

To avoid exposing the database connection string (MongoDB in this case),
an environment variable has been configured in the
`application.properties` file.\
This variable (`${MONGO_DB_URI}`) must be defined in the project from
**Edit Configurations**, inside the **Environment variables** field.

If you prefer, you can also place the connection string directly in the
`application.properties` file, although this is not the safest practice.

``` properties
spring.data.mongodb.uri=${MONGO_DB_URI}
```

All this is intended for development mode.\
When deploying the application to a cloud service, you should use the
environment variable `${MONGO_DB_URI}`, which is already configured in
`application.properties`.

Keep the configuration as follows:

``` properties
# Your project name
spring.application.name=apirestchallenge
# Your database name in mongoDB
spring.data.mongodb.database=games_db
# Your connection string from mongo
spring.data.mongodb.uri=${MONGO_DB_URI}
```

### Running Options

You can run the project in two ways:

#### Option 1: Using IntelliJ IDEA

Simply press the **Run** button from IntelliJ to start the application.

#### Option 2: From the terminal

``` bash
./mvnw clean package -DskipTests
java -jar target/apirestchallenge-0.0.1-SNAPSHOT.jar
```

### Postman

This repository includes a file that can be imported into Postman and
contains all the requests needed to test the API.

Note that, in order to perform the "get all users" request, you must
first create a user and then run the **"login user"** request to obtain
a token.\
This token must be used as **Bearer** in the authorization header of
protected requests such as retrieving all users.\
This allows you to properly test JWT authentication.

If the server starts correctly, the routes you can use are:

    http://0.0.0.0:8080/api/v1/users
    http://0.0.0.0:8080/api/v1/games
