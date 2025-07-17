package com.biblioteca;

public class Main {
    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager();
        manager.listarTodosLibros();
        manager.listarDisponibles();
        manager.listarNoDisponibles();

    }
}
