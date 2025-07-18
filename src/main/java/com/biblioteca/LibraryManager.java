package com.biblioteca;

import java.util.List;
import java.util.ArrayList;

public class LibraryManager implements LibraryService {
    // Array de libros
    //private Book[] catalogo;
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

    @Override
    public void buscarLibro(String texto) throws Exception, BookNotFoundException {
        texto = texto.toLowerCase();
        boolean encontrado = false;
        for (Book libro : catalogo) {
            if (
                    libro.titulo().toLowerCase().contains(texto) ||
                            libro.autor().toLowerCase().contains(texto) ||
                            libro.ISBN().toLowerCase().contains(texto)
            ) {
                System.out.println("\nLibro encontrado: ");
                System.out.println(libro.titulo() + " - " + libro.autor() + " - " +
                        libro.anio() + " - " + libro.ISBN());
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
        for (int i = 0; i < catalogo.size(); i++) {
            Book libro = catalogo.get(i);
            if (
                    ( libro.titulo().toLowerCase().contains(texto) ||
                            libro.autor().toLowerCase().contains(texto) ||
                            libro.ISBN().toLowerCase().contains(texto) ) && libro.disponibilidad()
            ) {
                System.out.println("\nLibro disponible para el préstamo: ");
                System.out.println(libro.titulo() + " - " + libro.autor() + " - " +
                        libro.anio() + " - " + libro.ISBN());
                Book nuevoLibro = new Book(
                        libro.titulo(),
                        libro.autor(),
                        libro.anio(),
                        libro.ISBN(),
                        false // ← marcamos como prestado
                );
                catalogo.set(i, nuevoLibro);
                System.out.println("\nLibro prestado con éxito.");
                encontrado = true;
                break;
            } else if (
                    ( libro.titulo().toLowerCase().contains(texto) ||
                            libro.autor().toLowerCase().contains(texto) ||
                            libro.ISBN().toLowerCase().contains(texto) ) && !libro.disponibilidad()
            ) {
                System.out.println("\nLibro No disponible. Ya en préstamo: ");
                System.out.println(libro.titulo() + " - " + libro.autor() + " - " +
                        libro.anio() + " - " + libro.ISBN());
                encontrado = true;
            }
        }
        if (!encontrado) {
            throw new BookNotFoundException("No se ha encontrado el libro con " + texto);
        }
    }

    @Override
    public void devolverLibro(String texto) throws Exception, BookNotFoundException {
        texto = texto.toLowerCase();
        boolean encontrado = false;
        for (int i = 0; i < catalogo.size(); i++) {
            Book libro = catalogo.get(i);
            if (
                    ( libro.titulo().toLowerCase().contains(texto) ||
                            libro.autor().toLowerCase().contains(texto) ||
                            libro.ISBN().toLowerCase().contains(texto) ) && !libro.disponibilidad()
            ) {
                System.out.println("\nLibro que quieres devolver: ");
                System.out.println(libro.titulo() + " - " + libro.autor() + " - " +
                        libro.anio() + " - " + libro.ISBN());
                Book nuevoLibro = new Book(
                        libro.titulo(),
                        libro.autor(),
                        libro.anio(),
                        libro.ISBN(),
                        true // ← marcamos como prestado
                );
                catalogo.set(i, nuevoLibro);
                System.out.println("\nLibro devuelto con éxito.");
                encontrado = true;
                break;
            } else if (
                    ( libro.titulo().toLowerCase().contains(texto) ||
                            libro.autor().toLowerCase().contains(texto) ||
                            libro.ISBN().toLowerCase().contains(texto) ) && libro.disponibilidad()
            ) {
                System.out.println("\nEste libro ya se encuentra en la biblioteca: ");
                System.out.println(libro.titulo() + " - " + libro.autor() + " - " +
                        libro.anio() + " - " + libro.ISBN());
                encontrado = true;
            }
        }
        if (!encontrado) {
            throw new BookNotFoundException("No se ha encontrado el libro con " + texto);
        }
    }

    @Override
    public void listarTodosLibros() {
        System.out.println("\nEl catálogo de libros de nuestra Biblioteca es el siguiente: ");
        for (Book libro : catalogo) {
            System.out.println(libro.titulo() + " - " + libro.autor() + " - " +
                    libro.anio() + " - " + libro.ISBN());
        }

    }

    @Override
    public void listarDisponibles() {
        System.out.println("\nLos libros que tenemos disponibles actualmente son los siguientes: ");
        for (Book libro : catalogo) {
            if (libro.disponibilidad()) {
                System.out.println(libro.titulo() + " - " + libro.autor() + " - " +
                        libro.anio() + " - " + libro.ISBN());
            }
        }
    }

    @Override
    public void listarNoDisponibles() {
        System.out.println("\nLos libros que NO tenemos disponibles actualmente son los siguientes: ");
        for (Book libro : catalogo) {
            if (!libro.disponibilidad()) {
                System.out.println(libro.titulo() + " - " + libro.autor() + " - " +
                        libro.anio() + " - " + libro.ISBN());
            }
        }

    }
}





