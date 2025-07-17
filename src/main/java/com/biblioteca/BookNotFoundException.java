package com.biblioteca;

public class BookNotFoundException extends Exception {
    public BookNotFoundException(String mensaje) {
        super(mensaje);
    }
}
