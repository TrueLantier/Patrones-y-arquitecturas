package libropatrones.diseñodesoftware.solid.singleresponsability;

public class Usuario {
    private String userName;
    private String email;

    public Usuario(String username, String email) {
        this.userName = username;
        this.email = email;
    }

    public String getUserName() { return userName; }

    public boolean validarEmail() {
        return email.contains("@") && email.contains(".");
    }

    // Pondré el mensaje de bienvenida también aquí, ya que están bastante relacionados.
    public void enviarEmailBienvenida() {
        System.out.println("Enviando correo de bienvenida a " + email);
    }
}

class UsuarioRepository {
    public void guardarDatos(Usuario usuario) {
        System.out.println("Guardando a " + usuario.getUserName() + " en la BD.");
        // Lógica de JPA
    }
}