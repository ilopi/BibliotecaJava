package com.biblioteca;

public interface LibraryService {
    void buscarLibro(String texto); // Metodo Buscar libro
    void sacarLibro(String texto); // Metodo Sacar libro
    void devolverLibro(String texto); // Metodo Devolver libro
    void getDetailsBook(); // Metodo Detalles libro para sacar / devolver
    void listarTodosLibros(); // Metodo para listar todos los libros
    void listarDisponibles(); // Metodo para listar libros disponibles
    void listarNoDisponibles(); // Metodo para listar libros no disponibles

}
