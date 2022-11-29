# afiliaciones
Este proyecto es el encargado de exponer los servicios exclusivos para afiliaciones.

---
## Tabla de Contenido

- [Descripción](#descripción)
- [Detalle de Funcionalidades](#detalle-de-funcionalidades)
- [Construido con](#construido-con)
- [Desarrollo](#desarrollo)
- [Autor](#autor)
---

## Descripción

El repositorio contiene los servicios relacionados sobre como registrar usuarios y consulta de usuarios por diferentes parametros.


## Detalle de Funcionalidades

### saveUser
Endpoint que permite guardar el usuario y retorna el mismo.

### getUserByEmail
Endpoint que se encarga de consultar por medio del parámetro email.

### getUserByDateCreate
Endpoint que se encarga de consultar por fecha de creación.

### getUserByDateModify
Endpoint que se encarga de consultar por fecha de modificación.

### getUserByDateLastLogin
Endpoint que se encarga de consultar por fecha de ultimo ingreso.

### getUserByActive
Endpoint que se encarga de consultar por el estado del usuario.

### getUserByContryCode
Endpoint que se encarga de consultar por código de pais registrado en el teléfono.

### getUserByCityCode
Endpoint que se encarga de consultar por código de ciudad registrado en el teléfono.

### getUserAll
Endpoint que se encarga de consultar todos los usuarios.

### getUserName
Endpoint que se encarga de consultar por nombre.

---

## Construido con

El código se encuentra implementado con Spring Boot Framework versión 2.4.2

## Desarrollo
1. Descargar Java y Maven.
2. Clone este repositorio.afiliaciones
3. Ejecute 'mvn clean install' y 'mvn spring-boot:run' para descargar dependencias para iniciar la aplicación.
4. Los endpoint estarán precedidos en la ruta http://localhost:8034/afiliaciones/swagger-ui/


## Autor

El equipo involucrado en la implementación de estos componentes se detalla a continuación:



