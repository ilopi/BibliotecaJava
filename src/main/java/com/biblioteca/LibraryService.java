package com.biblioteca;

public interface LibraryService {
    void buscarLibro(String texto) throws Exception, BookNotFoundException; // Metodo Buscar libro
    void sacarLibro(String texto) throws Exception, BookNotFoundException; // Metodo Sacar libro
    void devolverLibro(String texto) throws Exception, BookNotFoundException; // Metodo Devolver libro
    //void getDetailsBook() throws Exception, BookNotFoundException; // Metodo Detalles libro para sacar / devolver
    void listarTodosLibros(); // Metodo para listar todos los libros
    void listarDisponibles(); // Metodo para listar libros disponibles
    void listarNoDisponibles(); // Metodo para listar libros no disponibles

}
