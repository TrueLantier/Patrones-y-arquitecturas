package cursomouredev.solid.srp.gestiónbiblioteca;

import java.util.ArrayList;
import java.util.List;

public class GestiónBiblioteca {
    public List<Libro> libros = new ArrayList<>();
    public List<Usuario> usuarios = new ArrayList<>();
    public List<Préstamos> listaPréstamos = new ArrayList<>();
    public Usuario usuario;
    public Libro book;

    public void agregarLibros(Libro ... libro) {
        uno: for (Libro libroActual: libro) {
            for (Libro libroRegistrado: libros) {
                if (libroActual.getNombre().equals(libroRegistrado.getNombre())) {
                    libroRegistrado.cantidadDisponible += libroActual.cantidadDisponible;
                    continue uno;
                }
            }
            libros.add(libroActual);
        }
    }

    public void agregarUsuarios(Usuario ... usuario) {
        uno: for (Usuario usuarioActual: usuario) {
            for (Usuario usuarioRegistrado: usuarios) {
                if (usuarioActual.getNombre().equals(usuarioRegistrado.getNombre())) {
                    System.out.println("Usuario existente.");
                    continue uno;
                }
            }
            usuarios.add(usuarioActual);
        }
    }

    public void prestarLibro(String nombreUsuario, String nombreLibro) {
        if ( !(verificarUsuario(nombreUsuario) && verificarLibro(nombreLibro)) ) {
            throw new IllegalArgumentException("Nombre de usuario o libro incorrecto.");
        }

        Préstamos préstamo = new Préstamos(usuario, book);
        listaPréstamos.add(préstamo);
        System.out.println("Préstamo exitoso.");
    }

    public void devolverLibro(String nombreUsuario, String nombreLibro) {
        for (Usuario user: usuarios) {
            if (user.getNombre().equals(nombreUsuario)) {
                usuario = user;
                System.out.println("Usuario devolver exitoso.");
            }
        }

        for (Libro l: libros) {
            if (l.getNombre().equals(nombreLibro)) {
                book = l;
                l.cantidadDisponible++;
                System.out.println("Libro devolver exitoso.");
            }
        }

        listaPréstamos.removeIf(p -> p.usuario == usuario && p.libro == book);
    }

    // Se puede cambiar el equals() por contains().
    private boolean verificarUsuario(String nombre) {
        for (Usuario user: usuarios) {
            if (user.getNombre().equals(nombre)) {
                usuario = user;
                return true;
            }
        }
        return false;
    }

    private boolean verificarLibro(String nombre) {
        for (Libro l: libros) {
            if (l.getNombre().equals(nombre)) {
                if (l.cantidadDisponible > 0) {
                    l.cantidadDisponible--;
                    book = l;
                    return true;
                }   else {
                    System.out.println("Ya no hay más copias disponibles del libro " + l.getNombre());
                    return false;
                }
            }
        }
        return false;
    }
}