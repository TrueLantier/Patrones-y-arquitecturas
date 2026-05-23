package escuela.ejercicio3;

// Clase que representa la configuración global única (Singleton).
// Aplicación --> Gestor de libros.

public class ConfiguraciónGlobal {

    private String nombreApp;
    private String versión;
    private boolean modoDebug;

    private static ConfiguraciónGlobal instancia;

    private ConfiguraciónGlobal() {
        System.out.println("Almacenando la configuración global."); // Esto solo saldrá una vez. Cuando se inicialice.

        this.nombreApp = "Gestor de libros";
        this.versión = "1.0.0";
        this.modoDebug = false;
    }

    public static ConfiguraciónGlobal getInstancia() {
        if (instancia == null) {
            instancia = new ConfiguraciónGlobal();
        }

        return instancia;
    }

    // Opcional: método para mostrar toda la configuración
    @Override
    public String toString() {
        return "ConfiguracionGlobal{" +
                "nombreApp='" + nombreApp + '\'' +
                ", version='" + versión + '\'' +
                ", modoDebug=" + modoDebug +
                '}';
    }
}
