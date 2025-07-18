package com.biblioteca;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManager implements LibraryService {
    // Array de libros
    private List<Book> catalogo;

    // Constructor catálogo
    public LibraryManager() {
        catalogo = new ArrayList<>(List.of(
                new Book("Don Quijote", "Cervantes", 1605, "000-000", true),
                new Book("Historia de dos ciudades", "Charles Dickens", 1859, "000-001", true),
                new Book("El Señor de los Anillos", "J. R. R. Tolkien", 1954, "000-002", true),
                new Book("El Principito", "Antoine de Saint-Exupéry", 1943, "000-003", true),
                new Book("El Hobbit", "J. R. R. Tolkien", 1937, "000-004", true),
                new Book("El león, la bruja y el armario", "C. S. Lewis", 1950, "000-005", false)
        ));
    }

    // Metodo de impresion de libros
    private void imprimirLibro(Book libro) {
        System.out.println(libro.titulo() + " - " + libro.autor() + " - " +
                libro.anio() + " - " + libro.ISBN());
    }

    // Metodo de coincidencia de libros
    private boolean coincide(Book libro, String texto) {
        return libro.titulo().toLowerCase().contains(texto) ||
                libro.autor().toLowerCase().contains(texto) ||
                libro.ISBN().toLowerCase().contains(texto);
    }

    // Metodo para actualizar disponibilidad
    private void actualizarDisponibilidad(int i, Book libro, boolean disponible) {
        Book nuevoLibro = new Book(
                libro.titulo(),
                libro.autor(),
                libro.anio(),
                libro.ISBN(),
                disponible
        );
        catalogo.set(i, nuevoLibro);
    }


    @Override
    public void buscarLibro(String texto) throws Exception, BookNotFoundException {
        texto = texto.toLowerCase();
        boolean encontrado = false;
        for (Book libro : catalogo) {
            if (
                    coincide(libro, texto)
            ) {
                System.out.println("\nLibro encontrado: ");
                imprimirLibro(libro);
                encontrado = true;
            }
        }
        if (!encontrado) {
            throw new BookNotFoundException("No se ha encontrado el libro con " + texto);
        }
    }

    @Override
    public void sacarLibro(String texto) throws Exception, BookNotFoundException {
        texto = texto.toLowerCase();
        boolean encontrado = false;
        List<Integer> indicesCoincidentes = new ArrayList<>();
        for (int i = 0; i < catalogo.size(); i++) {
            Book libro = catalogo.get(i);
            if (
                    coincide(libro, texto) && libro.disponibilidad()
            ) {
                indicesCoincidentes.add(i);
            } else if (
                    coincide(libro, texto) && !libro.disponibilidad()
            ) {
                System.out.println("\nLibro No disponible. Ya en préstamo: ");
                imprimirLibro(libro);
                encontrado = true;
            }
        }
        if (indicesCoincidentes.isEmpty()) {
            throw new BookNotFoundException("\nLibro no encontrado.");
        } else if (indicesCoincidentes.size() == 1) {
            int i = indicesCoincidentes.get(0);
            Book libro = catalogo.get(i);
            imprimirLibro(libro);
            actualizarDisponibilidad(i, libro, false);
            System.out.println("\nLibro prestado con éxito.");
        } else {
            // Mostrar todos
            System.out.println("\nSe encontraron varios libros: ");
            for (int j = 0; j < indicesCoincidentes.size(); j++) {
                Book libro = catalogo.get(indicesCoincidentes.get(j));
                System.out.println((j + 1) + ". ");
                imprimirLibro(libro);
            }

            // Preguntar cuál
            System.out.print("\n¿Cuál desea sacar? Introduzca el número: ");
            Scanner scanner = new Scanner(System.in);
            int opcion = scanner.nextInt();
            int i = indicesCoincidentes.get(opcion - 1);
            Book libro = catalogo.get(i);
            actualizarDisponibilidad(i, libro, false);
            System.out.println("\nLibro prestado con éxito.");
        }
    }

    @Override
    public void devolverLibro(String texto) throws Exception, BookNotFoundException {
        texto = texto.toLowerCase();
        boolean encontrado = false;
        List<Integer> indicesCoincidentes = new ArrayList<>();
        for (int i = 0; i < catalogo.size(); i++) {
            Book libro = catalogo.get(i);
            if (
                    coincide(libro, texto) && !libro.disponibilidad()
            ) {
                indicesCoincidentes.add(i);
            } else if (
                    coincide(libro, texto) && libro.disponibilidad()
            ) {
                System.out.println("\nNo disponible para la devolución por encontrarse en la biblioteca: ");
                imprimirLibro(libro);
                encontrado = true;
            }
        }
        if (indicesCoincidentes.isEmpty()) {
            throw new BookNotFoundException("\nLibro no encontrado.");
        } else if (indicesCoincidentes.size() == 1) {
            int i = indicesCoincidentes.get(0);
            Book libro = catalogo.get(i);
            imprimirLibro(libro);
            actualizarDisponibilidad(i, libro, true);
            System.out.println("\nLibro devuelto con éxito.");
        } else {
            // Mostrar todos
            System.out.println("\nSe encontraron varios libros: ");
            for (int j = 0; j < indicesCoincidentes.size(); j++) {
                Book libro = catalogo.get(indicesCoincidentes.get(j));
                System.out.println((j + 1) + ". ");
                imprimirLibro(libro);
            }

            // Preguntar cuál
            System.out.print("\n¿Cuál desea devolver? Introduzca el número: ");
            Scanner scanner = new Scanner(System.in);
            int opcion = scanner.nextInt();
            int i = indicesCoincidentes.get(opcion - 1);
            Book libro = catalogo.get(i);
            actualizarDisponibilidad(i, libro, false);
            System.out.println("\nLibro devuelto con éxito.");
        }
    }

    @Override
    public void listarTodosLibros() {
        System.out.println("\nEl catálogo de libros de nuestra Biblioteca es el siguiente: ");
        for (Book libro : catalogo) {
            imprimirLibro(libro);
        }

    }

    @Override
    public void listarDisponibles() {
        boolean encontrado = false;
        System.out.println("\nLos libros que tenemos disponibles actualmente son los siguientes: ");
        for (Book libro : catalogo) {
            if (libro.disponibilidad()) {
                imprimirLibro(libro);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println(" No hay libros disponibles actualmente.");
        }
    }

    @Override
    public void listarNoDisponibles() {
        boolean encontrado = false;
        System.out.println("\nLos libros que NO tenemos disponibles actualmente son los siguientes: ");
        for (Book libro : catalogo) {
            if (!libro.disponibilidad()) {
                imprimirLibro(libro);
                encontrado = true;
            }

        }
        if (!encontrado) {
            System.out.println("Todos los libros están disponibles actualmente.");
        }
    }

}





