package cursomouredev.solid.srp.gestiónbiblioteca;

public class Libro {
    private String nombre;
    private String autor;
    public int cantidadDisponible; // Se asume al principio que están todos.
    private boolean prestado;

    public Libro(String nombre, String autor, int cantidadAgregada) {
        this.nombre = nombre;
        this.autor = autor;
        verificarCantidad(cantidadAgregada);
        this.cantidadDisponible = cantidadAgregada;
        prestado = false;
    }

    private void verificarCantidad(int cantidad) throws IllegalArgumentException{
        if ((cantidad <= 0) || (cantidad >= 1000)) {
            throw new IllegalArgumentException("Cantidad incorrecta.");
        }
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
