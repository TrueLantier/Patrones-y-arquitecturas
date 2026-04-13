package cursomouredev;

import cursomouredev.solid.srp.gestiónbiblioteca.*;

public class Main {
    public static void main(String[] args) {
        GestiónBiblioteca miBiblioteca = new GestiónBiblioteca();

        Libro l1 = new Libro("Libro 1", "Autor 1", 10);
        Libro l2 = new Libro("Libro 2", "Autor 2", 2);
        Libro l3 = new Libro("Libro 3", "Autor 3", 3);
        Libro l4 = new Libro("Libro 4", "Autor 4", 4);
        Libro l5 = new Libro("Libro 5", "Autor 5", 5);
        Libro l6 = new Libro("Libro 6", "Autor 6", 6);
        Libro l7 = new Libro("Libro 7", "Autor 7", 7);

        miBiblioteca.agregarLibros(l1, l2, l3, l4, l5, l6, l7);
        for (Libro l: miBiblioteca.libros) {
            System.out.println(l.toString());
        }
    }
}
