package cursomouredev.solid.srp.gestiónbiblioteca;
import java.time.*;

public class Préstamos {
    public Usuario usuario;
    public Libro libro;
    public LocalDate fecha;

    public Préstamos(Usuario usuario, Libro libro) {
        this.usuario = usuario;
        this.libro = libro;
        fecha = LocalDate.now();
    }
}
