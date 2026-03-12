package libropatrones.diseñodesoftware.solid.singleresponsability;

public class UsuarioIncorrecto {
    private String userName;
    private String email;

    public UsuarioIncorrecto(String username, String email) {
        this.userName = username;
        this.email = email;
    }

    public boolean validarEmail() {
        return email.contains("@") && email.contains(".");
    }

    public void guardarEnBaseDeDatos() {
        System.out.println("Guardando a " + userName + " en la BD.");
    }

    public void enviarEmailBienvenida() {
        System.out.println("Enviando correo de bienvenida a " + email);
    }
}