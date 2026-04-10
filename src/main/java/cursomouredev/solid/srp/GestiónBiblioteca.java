package cursomouredev.solid.srp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GestiónBiblioteca {
    List<Libro> libros = new ArrayList<>();
    List<Usuario> usuarios = new ArrayList<>();
    boolean problemaPréstamo;

    List<Préstamo> préstamos = new ArrayList<>();

    public void agregarLibros(Libro ... libro) {
        libros.addAll(Arrays.asList(libro));
    }

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

class Libro {
    private String nombre;
    private String autor;
    private int cantidadDisponible; // Se asume al principio que están todos.
    private boolean prestado;

    public Libro(String nombre, String autor, int cantidadDisponible) {
        this.nombre = nombre;
        this.autor = autor;
        verificarCantidad(cantidadDisponible);
        this.cantidadDisponible = cantidadDisponible;
        prestado = false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    private void verificarCantidad(int cantidad) throws IllegalArgumentException{
        if (cantidad <= 0 || cantidad >= 1000) {
            System.out.println("Cantidad incorrecta");
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return "Libro{" +
                "nombre='" + nombre + '\'' +
                ", autor='" + autor + '\'' +
                ", cantidadDisponible=" + cantidadDisponible +
                ", prestado=" + prestado +
                '}';
    }
}

class Usuario {
    private String nombre;
    private int id;
    private String correo;

    public Usuario(String nombre, int id, String correo) {
        this.nombre = nombre;
        this.id = id;
        verificarCorreo(correo);
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void verificarCorreo(String correo) throws IllegalArgumentException{
        if (!correo.contains("@")) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                ", correo='" + correo + '\'' +
                '}';
    }
}

class Préstamo extends GestiónBiblioteca{
    private String nombreUsuario;
    private String nombreLibro;

    public Préstamo(String nombreUsuario, String nombreLibro) {
        if (verificarUsuario(nombreUsuario) && verificarLibro(nombreLibro)) {
            throw new IllegalArgumentException("Nombre de usuario o libro incorrecto.");
        }

        this.nombreUsuario = nombreUsuario;
        this.nombreLibro = nombreLibro;


    }

    // Se puede cambiar el equals() por contains().
    private boolean verificarUsuario(String nombre) {
        for (Usuario user: usuarios) {
            if (user.getNombre().equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    // Sirve para nombre de autor o del libro.
    private boolean verificarLibro(String nombre) {
        for (Libro l: libros) {
            if (l.getNombre().equals(nombre) || l.getAutor().equals(nombre)) {
                int disp = l.getCantidadDisponible();
                if (disp > 0) {
                    System.out.println("Préstamo exitoso.");
                    l.setCantidadDisponible( --disp );
                    return true;
                }   else {
                    throw new IllegalArgumentException("Ya no hay más copias disponibles del libro.");
                }
            }
        }
        return false;
    }

//    private boolean disponibilidad() {
//
//    }
}