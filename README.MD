# 📚 Gestor de Biblioteca en Java

Este es un proyecto simple de consola hecho en Java para gestionar una pequeña biblioteca de libros. Permite consultar, prestar y devolver libros a través de un menú interactivo, y está pensado para estudiantes que están empezando con Java y quieren practicar:

- Clases y records
- Interfaces
- Listas (`ArrayList`)
- Condicionales y bucles
- `Scanner` y entrada de usuario
- Manejo de excepciones
- Uso de `Streams` (parcial)
- Programación estructurada

---

## 🚀 Funcionalidades

✅ Listar todos los libros  
✅ Listar solo libros disponibles  
✅ Listar solo libros prestados  
✅ Buscar libros por título, autor o ISBN  
✅ Prestar libros disponibles  
✅ Devolver libros prestados  
✅ Menú interactivo por consola  
✅ Manejo de errores con mensajes claros

---

## 🧠 Tecnologías usadas

- **Java 17+**
- IntelliJ IDEA (recomendado)
- Maven (estructura de proyecto estándar)

---

## 📁 Estructura del proyecto

```
📦 src/
 └── main/
     └── java/
         └── com.biblioteca/
             ├── Main.java
             ├── Book.java              // record
             ├── LibraryManager.java    // lógica principal
             ├── LibraryService.java    // interfaz
             ├── BookNotFoundException.java
             └── LibraryUtils.java      // métodos utilitarios (opcional)
```

---

## 🖥️ Captura de uso

```
--- MENÚ BIBLIOTECA ---
1. Listar todos los libros
2. Listar libros disponibles
3. Listar libros prestados
4. Buscar libro
5. Sacar libro
6. Devolver libro
7. Salir
Elige una opción: 5
Introduce texto para sacar libro: el

Se encontraron varios libros:
1. El Principito - Antoine de Saint-Exupéry - 1943
2. El Hobbit - J. R. R. Tolkien - 1937
¿Cuál desea sacar? Introduce el número: 2

✅ Libro prestado con éxito.
```

---

## ⚠️ Notas

- Los libros están pre-cargados en el programa al iniciar
- Los `Book` son `record`, por lo que son inmutables. Para modificar disponibilidad se crea uno nuevo
- No se usan bases de datos ni archivos: todos los datos están en memoria

---

## 🛠️ Cómo usarlo

1. Clona el repositorio
2. Abre el proyecto en IntelliJ IDEA
3. Asegúrate de tener Java 17+ configurado
4. Ejecuta `Main.java`
5. Usa el menú por consola para interactuar

---

## 💡 Mejoras futuras (si te animas)

- Guardar y leer libros desde archivo o base de datos
- Añadir interfaz gráfica con JavaFX o Swing
- Ordenar libros al listar
- Permitir añadir nuevos libros desde el menú

---

## 🧑‍💻 Autora

✨ Proyecto hecho por Isabel Sánchez López como práctica personal de Java