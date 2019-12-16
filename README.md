# Prueba Tecnica grupo BWL.

## 

## API.

La api esta desarrollada en Java con el framework Spring, se genero una api la cual es capas de leer una secuencia de ADN y determinar si contiene mutación.

Para el desarrollo del proyecto se ocuparon Herramientas como MySQL, Postman, Flyway, Lombok, Swagger2 y la UI de Swagger.

## Base de datos.

La aplicacion esta completamente preparada para realizar la migracion de la base de datos a un motor MySQL lo unico se se debe hacer es crear la base de datos antes de correr el api,cambiar el usuario y contraseña de la base de datos que se encuentran en el application.yml, lo cual se hace con la siguiente sentencia SQL.

```
CREATE DATABASE bwl;
```

## Correr api localmente.

Despues de crear la base de datos se recomienda hacer un Maven update para actualizar dependencias, y seguido de correr la app con el archivo principal **MutationApplication** localizado en el paquete **mx.com.bwl.mutation**, este se correra como una Spring Boot App.

## EndPoints 

La API cuenta con una apartado de OpenApi en el cual se exponen los EndPoints y sus respectivos JSON para la realizacion de request. Se puede entrar a este desde la direccion http://localhost:8080/swagger-ui.html#/user-controller

## Entidades.

Las entidades se crearon con Lombok para optimizar la lectura del codigo.

## Repository

Se ocupo el JPA Repositori para el mapeo de Entidades asi como consultas personalizadas con JPA para consultas mas especificas.

## Services.

Se implementaron los service correspondientes.

## Controlers.

Se mapearon los EndPoints con RestControler aplicando politicas de CORS para la disponibilidad de estos mismos, asi como la creacion del OpenAPI.



## Despliege.

Se planea desplegar la API con ayuda de Docker para brindar portabilidad al compartir codigo con terceros.
