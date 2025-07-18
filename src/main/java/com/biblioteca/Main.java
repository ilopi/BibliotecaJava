package com.biblioteca;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        LibraryManager manager = new LibraryManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(
                    "--- MENÚ BIBLIOTECA ---\n" +
                            "1. Listar todos los libros\n" +
                            "2. Listar libros disponibles\n" +
                            "3. Listar libros prestados\n" +
                            "4. Buscar libro\n" +
                            "5. Sacar libro\n" +
                            "6. Devolver libro\n" +
                            "7. Salir\n" +
                            "Elige una opción:"
            );
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar salto de línea

            switch (opcion) {
                case 1:
                    manager.listarTodosLibros();
                    System.out.println("\nPulsa ENTER para continuar...");
                    scanner.nextLine();
                    break;
                case 2:
                    manager.listarDisponibles();
                    System.out.println("\nPulsa ENTER para continuar...");
                    scanner.nextLine();
                    break;
                case 3:
                    manager.listarNoDisponibles();
                    System.out.println("\nPulsa ENTER para continuar...");
                    scanner.nextLine();
                    break;
                case 4:
                    System.out.print("\nIntroduce texto para buscar un libro: ");
                    String textoBuscar = scanner.nextLine();
                    manager.buscarLibro(textoBuscar);
                    System.out.println("\nPulsa ENTER para continuar...");
                    scanner.nextLine();
                    break;
                case 5:
                    System.out.print("\nIntroduce texto del libro que quieres sacar: ");
                    String textoSacar = scanner.nextLine();
                    manager.sacarLibro(textoSacar);
                    System.out.println("\nPulsa ENTER para continuar...");
                    scanner.nextLine();
                    break;
                case 6:
                    System.out.print("\nIntroduce texto del libro que quieres devolver: ");
                    String textoDevolver = scanner.nextLine();
                    manager.devolverLibro(textoDevolver);
                    System.out.println("\nPulsa ENTER para continuar...");
                    scanner.nextLine();
                    break;
                case 7:
                    System.out.println("\n¡Hasta pronto!");
                    return;
                default:
                    System.out.println("\nOpción no válida.");
                    System.out.println("\nPulsa ENTER para continuar...");
                    scanner.nextLine();

            }
        }

    }
}
