package com.biblioteca;

public class Main {
    public static void main(String[] args) {
        // Prueba record:
        Book book = new Book("Don Quijote", "Cervantes", 1605, "000-000", true);
        System.out.println(book.titulo());
    }
}
