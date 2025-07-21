# Gestor de Biblioteca en Java

Este proyecto es una aplicación de consola desarrollada en Java que simula el funcionamiento básico de una biblioteca. Permite realizar operaciones comunes como listar libros, buscarlos por diferentes criterios, y registrar préstamos y devoluciones, todo a través de un menú interactivo en la terminal.

Está dirigido a personas que están aprendiendo Java y desean aplicar conceptos fundamentales del lenguaje en un proyecto funcional y estructurado.

---

## Funcionalidades principales

- Listado completo del catálogo
- Filtro por libros disponibles o prestados
- Búsqueda por título, autor o ISBN
- Préstamo de libros disponibles
- Devolución de libros prestados
- Menú de navegación interactivo
- Validación de entradas y manejo de errores

---

## Tecnologías utilizadas

- Java 17 o superior
- IntelliJ IDEA como entorno de desarrollo recomendado
- Estructura de proyecto con Maven

---

## Estructura del proyecto

src/
└── main/
└── java/
└── com.biblioteca/
├── Main.java
├── Book.java
├── LibraryManager.java
├── LibraryService.java
├── BookNotFoundException.java
└── LibraryUtils.java

---

## Ejemplo de uso

--- MENÚ BIBLIOTECA ---

Listar todos los libros

Listar libros disponibles

Listar libros prestados

Buscar libro

Sacar libro

Devolver libro

Salir
Elige una opción: 5
Introduce texto para sacar libro: el

Se encontraron varios libros:

El Principito - Antoine de Saint-Exupéry - 1943

El Hobbit - J. R. R. Tolkien - 1937
¿Cuál desea sacar? Introduce el número: 2

---

## Consideraciones

- Los datos se mantienen en memoria y no se persisten al cerrar la aplicación.
- La clase `Book` está implementada como un `record` y, por tanto, es inmutable. Para modificar su disponibilidad, se crea una nueva instancia.
- La colección de libros es fija y cargada en el inicio del programa.

---

## Cómo ejecutar

1. Clonar este repositorio
2. Abrir el proyecto con IntelliJ IDEA
3. Asegurarse de tener Java 17 o superior configurado
4. Ejecutar `Main.java` desde el IDE
5. Interactuar con la aplicación mediante el menú de consola

---

## Posibles mejoras futuras

- Lectura y escritura de datos desde un archivo o base de datos
- Incorporación de interfaz gráfica (JavaFX o Swing)
- Funcionalidad para añadir libros manualmente
- Ordenamiento por diferentes criterios

---

## Autora

Desarrollado por **Isabel Sánchez López** como práctica personal de programación en Java.
