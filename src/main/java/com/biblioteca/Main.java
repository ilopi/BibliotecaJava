package com.biblioteca;

public class Main {
    public static void main(String[] args) throws Exception {
        LibraryManager manager = new LibraryManager();
        //manager.listarTodosLibros();
        //manager.listarDisponibles();
        //manager.listarNoDisponibles();
        //manager.buscarLibro("prin");
        //manager.sacarLibro("prin");
        //manager.listarNoDisponibles();
        manager.devolverLibro("bruja");

    }
}
