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
    public void buscarLibro(String texto) {
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
            System.out.println("No se ha encontrado el libro con " + texto);
        }
    }

    @Override
    public void sacarLibro(String texto) {

    }

    @Override
    public void devolverLibro(String texto) {

    }

    @Override
    public void getDetailsBook() {

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





