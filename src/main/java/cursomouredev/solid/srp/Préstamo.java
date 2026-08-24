package cursomouredev.solid.srp;

import java.time.*;

public class Préstamo {
    public Usuario usuario;
    public Libro libro;
    public LocalDate fecha;

    public Préstamo(Usuario usuario, Libro libro) {
        this.usuario = usuario;
        this.libro = libro;
        fecha = LocalDate.now();
    }
}
