package cursomouredev;

import cursomouredev.solid.srp.gestiónbiblioteca.*;

public class Main {
    public static void main(String[] args) {
        GestiónBiblioteca miBiblioteca = getGestiónBiblioteca();

        for (Libro l: miBiblioteca.libros) {
            System.out.println(l);
        }

        Usuario u1 = new Usuario("User 1", 1, "1@gmail");
        Usuario u2 = new Usuario("User 2", 2, "2@gmail");
        Usuario u3 = new Usuario("User 3", 3, "3@gmail");
        Usuario u4 = new Usuario("User 4", 4, "4@gmail");
        Usuario u5 = new Usuario("User 5", 5, "5@gmail");

        miBiblioteca.agregarUsuarios(u1, u2, u3, u4, u5);
        for (Usuario u: miBiblioteca.usuarios) {
            System.out.println(u);
        }

        miBiblioteca.prestarLibro("User 1", "Libro 1");
        miBiblioteca.prestarLibro("User 2", "Libro 2");
        miBiblioteca.prestarLibro("User 3", "Libro 2");
        miBiblioteca.prestarLibro("User 3", "Libro 3");

        for (Libro l: miBiblioteca.libros) {
            System.out.println(l);
        }

        for (Préstamos p: miBiblioteca.listaPréstamos) {
            System.out.println(p.libro + " <-> " + p.usuario + " fecha: " + p.fecha);
        }
    }

    private static GestiónBiblioteca getGestiónBiblioteca() {
        GestiónBiblioteca miBiblioteca = new GestiónBiblioteca();

        Libro l1 = new Libro("Libro 1", "Autor 1", 10);
        Libro l2 = new Libro("Libro 2", "Autor 2", 2);
        Libro l3 = new Libro("Libro 3", "Autor 3", 3);
        Libro l4 = new Libro("Libro 4", "Autor 4", 4);
        Libro l5 = new Libro("Libro 5", "Autor 5", 5);
        Libro l6 = new Libro("Libro 6", "Autor 6", 6);
        Libro l7 = new Libro("Libro 7", "Autor 7", 7);

        Libro l8 = new Libro("Libro 1", "Autor 1", 2);

        miBiblioteca.agregarLibros(l1, l2, l3, l4, l5, l6, l7, l8);
        return miBiblioteca;
    }
}
