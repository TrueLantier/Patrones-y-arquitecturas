package cursomouredev.solid.srp.gestiónbiblioteca;

public class Usuario {
    private String nombre;
    private int id;
    private String correo;

    public Usuario(String nombre, int id, String correo) {
        this.nombre = nombre;
        this.id = id;
        verificarCorreo(correo);
        this.correo = correo;
    }

    public void verificarCorreo(String correo) throws IllegalArgumentException{
        if (!correo.contains("@")) {
            throw new IllegalArgumentException("Correo incorrecto.");
        }
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

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                ", correo='" + correo + '\'' +
                '}';
    }
}
