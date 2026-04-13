package cursomouredev.solid.srp.gestiónbiblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GestiónBiblioteca {
    public List<Libro> libros = new ArrayList<>();
    public List<Usuario> usuarios = new ArrayList<>();
    boolean problemaPréstamo;

    List<Préstamo> préstamos = new ArrayList<>();

    public void agregarLibros(Libro ... libro) {
        libros.addAll(Arrays.asList(libro));
    }
}