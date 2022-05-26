# Prueba Técnica - Programador (Java Spring - Full Stack)

La siguiente es una prueba para evaluar a los postulantes a programador **Java Spring - Full Stack**.

## INTRODUCCIÓN

Este repositorio contiene una serie de requerimientos de un Caso Práctico, que busca evaluar las capacidades técnicas del candidato con respecto a las principales funciones y responsabilidades que se requieren dentro del área de Desarrollo de Tecnología.

#### ¿Qué se busca evaluar?

Principalmente los siguientes aspectos:

+ Creatividad para resolver los requerimientos,
+ Calidad del código entregado (estructura y buenas prácticas),
+ Eficiencia de los algoritmos entregados,
+ Familiaridad con Frameworks y plataformas de desarrollo.

## IMPORTANTE

1. Se solicita crear la aplicación utilizando estas tecnologías:

	Backend [Java spring boot ](https://spring.io/projects/spring-boot)

	Base de datos [MongoDB ](https://www.mongodb.com/es)

	Frontend [Angular ](https://angular.io/)

2. Se requiere de una **cuenta de GitHub** para realizar este ejercicio.

3.  **Antes de comenzar a programar:**

* Realizar un `Fork` de este repositorio (https://github.com/iseijasunow/Prueba-Tecnica-Programador-Java-Spring---Full-Stack).
* Clonar el fork a su máquina local `git clone git@github.com:USERNAME/FORKED-PROJECT.git`
* Crear un `branch` en su cuenta de GitHub utilizando su nombre completo.

4.  **Al finalizar**, existen 2 (dos) opciones para entregar su proyecto:

* 1) Realizar un `Commit` de su proyecto, **enviar un `Pull Request` al branch con su NOMBRE**, y notificar a la siguiente dirección de correo electrónico [mrequena@unow.es](mailto:mrequena@unow.es).

* 2) Crear un archivo comprimido (_.zip_ o _.rar_) de su proyecto y enviar a la siguiente dirección de correo electrónico [mrequena@unow.es](mailto:mrequena@unow.es).

## EJERCICIO PRÁCTICO

**Objetivo:** Crear una aplicación para el envió programado de correos electrónicos a una lista de contactos
 
#### Requerimientos generales

1. Registrar una lista de contactos: con nombre, apellido, email, sexo y dirección.

2. Listar estos contactos.

3. Editar los contactos.

4. Eliminar los contactos (Solicitar confirmación)

5. Filtros para búsqueda de contactos (nombre, apellido, email, sexo)

6. Crear evento "cron job" para enviar correos:  
	 - Seleccionando una fecha y hora de envío.
	 - Titulo del mensaje.
	 - Contenido del mensaje.
	 - Lista de contactos que recibirán el correo "Puedo seleccionar todos o algunos contactos en específico".

7. Listar eventos **pendientes** y **finalizados**

8. Editar eventos **pendientes** 

9. Cancelar eventos **pendientes** 

10. Eliminar eventos  **finalizados**