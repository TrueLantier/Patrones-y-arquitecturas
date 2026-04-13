package cursomouredev.solid.srp.gestiónbiblioteca;

public class Préstamo extends GestiónBiblioteca{
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
}
